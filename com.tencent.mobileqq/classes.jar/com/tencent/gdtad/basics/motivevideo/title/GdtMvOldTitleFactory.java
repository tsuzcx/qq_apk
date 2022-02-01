package com.tencent.gdtad.basics.motivevideo.title;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;

public class GdtMvOldTitleFactory
  implements IGdtMvTitleFactory
{
  private final String a = "GdtMvOldTitleFactory";
  private TextView b;
  private ImageView c;
  
  public void a(long paramLong1, long paramLong2, long paramLong3)
  {
    if (paramLong1 > 0L)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131903196));
      ((StringBuilder)localObject).append(paramLong2);
      ((StringBuilder)localObject).append("s");
      localObject = ((StringBuilder)localObject).toString();
      GdtMvTitleUtil.a(this.b, (String)localObject, 0);
      return;
    }
    GdtMvTitleUtil.a(this.b, "", 8);
  }
  
  public void a(Context paramContext, boolean paramBoolean)
  {
    if (this.c == null)
    {
      QLog.i("GdtMvOldTitleFactory", 1, "refreshVoiceIconDrawableInner return");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("refreshVoiceIconDrawableInner ");
    localStringBuilder.append(paramBoolean);
    QLog.i("GdtMvOldTitleFactory", 1, localStringBuilder.toString());
    if (paramBoolean)
    {
      paramContext = paramContext.getResources().getDrawable(2130838503);
      GdtMvTitleUtil.a(this.c, paramContext, 2131889980);
      return;
    }
    paramContext = paramContext.getResources().getDrawable(2130838504);
    GdtMvTitleUtil.a(this.c, paramContext, 2131889979);
  }
  
  public void a(ViewGroup paramViewGroup, GdtMvTitleHelper paramGdtMvTitleHelper)
  {
    paramViewGroup.addView(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131624950, paramViewGroup, false));
    this.b = ((TextView)paramViewGroup.findViewById(2131434368));
    this.c = ((ImageView)paramViewGroup.findViewById(2131434369));
    paramGdtMvTitleHelper.a = this.c;
    paramGdtMvTitleHelper.a.setOnClickListener(paramGdtMvTitleHelper);
    paramGdtMvTitleHelper.b = paramViewGroup.findViewById(2131434366);
    paramGdtMvTitleHelper.b.setOnClickListener(paramGdtMvTitleHelper);
    paramGdtMvTitleHelper.c = ((TextView)paramViewGroup.findViewById(2131434367));
    paramGdtMvTitleHelper.c.setOnClickListener(paramGdtMvTitleHelper);
    paramGdtMvTitleHelper.c.setVisibility(8);
    if (paramGdtMvTitleHelper.f != 0) {
      paramGdtMvTitleHelper.b.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.basics.motivevideo.title.GdtMvOldTitleFactory
 * JD-Core Version:    0.7.0.1
 */