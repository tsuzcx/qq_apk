package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.aelight.camera.ae.data.AEARCakeMaterial;
import com.tencent.aelight.camera.ae.data.AEGiftMaterial;
import com.tencent.aelight.camera.log.AEQLog;
import java.util.List;

public class AEARCakeProvidewView
  extends FrameLayout
{
  private RecyclerView a;
  private View b;
  private AEARCakeMaterialAdapter c;
  private AEARCakePanel.AEARCakePanelListener d;
  private TextView e;
  
  public AEARCakeProvidewView(@NonNull Context paramContext, AEARCakePanel.AEARCakePanelListener paramAEARCakePanelListener)
  {
    super(paramContext);
    this.d = paramAEARCakePanelListener;
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.b = LayoutInflater.from(getContext()).inflate(2064056321, this);
    this.a = ((RecyclerView)this.b.findViewById(2063991076));
    LinearLayoutManager localLinearLayoutManager = new LinearLayoutManager(paramContext, 0, false);
    this.a.setLayoutManager(localLinearLayoutManager);
    this.e = ((TextView)this.b.findViewById(2063991215));
    this.c = new AEARCakeMaterialAdapter(paramContext, this.d);
    AEARCakeMaterialManager.a().a(this.c);
    this.a.setAdapter(this.c);
    this.a.addItemDecoration(new AEARCakeProvidewView.1(this));
  }
  
  public void a()
  {
    AEARCakeMaterialManager.a().a(null);
  }
  
  public void a(List<AEGiftMaterial> paramList, int paramInt)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      int i = 0;
      Object localObject;
      while (i < paramList.size())
      {
        if (((AEGiftMaterial)paramList.get(i)).c() != null)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("arcake : categories.get(0).materialList :");
          ((StringBuilder)localObject).append(((AEGiftMaterial)paramList.get(i)).c().t);
          AEQLog.a("AEARCakeProvidewView", ((StringBuilder)localObject).toString());
        }
        i += 1;
      }
      if (this.e != null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(getContext().getString(2064187639));
        ((StringBuilder)localObject).append(String.valueOf(paramList.size()));
        ((StringBuilder)localObject).append(getContext().getString(2064187640));
        localObject = ((StringBuilder)localObject).toString();
        this.e.setText((CharSequence)localObject);
      }
      this.c.a(paramList, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.AEARCakeProvidewView
 * JD-Core Version:    0.7.0.1
 */