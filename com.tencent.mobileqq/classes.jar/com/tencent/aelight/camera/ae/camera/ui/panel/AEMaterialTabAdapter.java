package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.aelight.camera.ae.control.AEQIMManager;
import com.tencent.aelight.camera.ae.data.AEMaterialCategory;
import com.tencent.aelight.camera.ae.data.AEMaterialManager;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;

public class AEMaterialTabAdapter
  extends PagerAdapter
{
  public HashMap<Integer, AEGridView> a = new HashMap();
  private Context b;
  private List<AEMaterialCategory> c;
  private AEMaterialPanel.AEMaterialPanelListener d;
  private AEMaterialManager e;
  
  public AEMaterialTabAdapter(Context paramContext, AEMaterialPanel.AEMaterialPanelListener paramAEMaterialPanelListener)
  {
    this.b = paramContext;
    this.d = paramAEMaterialPanelListener;
    this.e = ((AEMaterialManager)AEQIMManager.a(1));
  }
  
  private void a(AEMaterialAdapter paramAEMaterialAdapter, int paramInt)
  {
    this.e.a(paramAEMaterialAdapter, 112);
    this.e.a(paramAEMaterialAdapter, 113);
    this.e.a(paramAEMaterialAdapter, 1024);
    this.e.a(paramAEMaterialAdapter, 114);
    this.e.a(paramAEMaterialAdapter, 111);
    this.e.a(paramAEMaterialAdapter, 115);
    if (paramInt == 0) {
      this.e.a(paramAEMaterialAdapter, 111);
    }
  }
  
  public AEMaterialCategory a(int paramInt)
  {
    List localList = this.c;
    if ((localList != null) && (localList.size() > paramInt) && (paramInt >= 0)) {
      return (AEMaterialCategory)this.c.get(paramInt);
    }
    return null;
  }
  
  public void a(List<AEMaterialCategory> paramList)
  {
    this.c = paramList;
  }
  
  public void b(int paramInt)
  {
    AEQLog.a("PtvTemplateViewPagerAdapter", "dtexpose reportTabFirstExpose");
    Object localObject = (AEGridView)this.a.get(Integer.valueOf(paramInt));
    if (localObject == null) {
      return;
    }
    localObject = (AEMaterialAdapter)((AEGridView)localObject).getAdapter();
    if (localObject != null)
    {
      List localList = this.c;
      if (localList != null)
      {
        if (localList.get(paramInt) == null) {
          return;
        }
        ((AEMaterialAdapter)localObject).b(((AEMaterialCategory)this.c.get(paramInt)).a);
      }
    }
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)this.a.get(Integer.valueOf(paramInt)));
    paramViewGroup = (AEGridView)this.a.get(Integer.valueOf(paramInt));
    if (paramViewGroup != null)
    {
      paramViewGroup = (AEMaterialAdapter)paramViewGroup.getAdapter();
      this.e.a(paramViewGroup);
    }
  }
  
  public int getCount()
  {
    return this.c.size();
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    AEGridView localAEGridView = (AEGridView)this.a.get(Integer.valueOf(paramInt));
    int j = 0;
    int i = 0;
    Object localObject;
    if (localAEGridView == null)
    {
      localAEGridView = new AEGridView(this.b);
      localObject = this.b;
      AEMaterialPanel.AEMaterialPanelListener localAEMaterialPanelListener = this.d;
      boolean bool;
      if (paramInt == 0) {
        bool = true;
      } else {
        bool = false;
      }
      localObject = new AEMaterialAdapter((Context)localObject, localAEGridView, localAEMaterialPanelListener, bool);
      a((AEMaterialAdapter)localObject, paramInt);
      localAEGridView.a(new AEMaterialTabAdapter.1(this, (AEMaterialAdapter)localObject));
      if (paramInt == 1) {
        i = 1;
      }
      this.a.put(Integer.valueOf(paramInt), localAEGridView);
    }
    else
    {
      localObject = (AEMaterialAdapter)localAEGridView.getAdapter();
      a((AEMaterialAdapter)localObject, paramInt);
      i = j;
    }
    ((AEMaterialAdapter)localObject).a(((AEMaterialCategory)this.c.get(paramInt)).a);
    if (i != 0)
    {
      AEQLog.a("PtvTemplateViewPagerAdapter", "dtexpose isFirstTabExpose");
      ((AEMaterialAdapter)localObject).b(((AEMaterialCategory)this.c.get(paramInt)).a);
    }
    localAEGridView.setAdapter((RecyclerView.Adapter)localObject);
    paramViewGroup.addView(localAEGridView);
    if (QLog.isColorLevel())
    {
      paramViewGroup = new StringBuilder();
      paramViewGroup.append("instantiateItem: invoked. info: ptvTemplateAdapter = ");
      paramViewGroup.append(localObject);
      QLog.i("PtvTemplateViewPagerAdapter", 2, paramViewGroup.toString());
    }
    return localAEGridView;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.AEMaterialTabAdapter
 * JD-Core Version:    0.7.0.1
 */