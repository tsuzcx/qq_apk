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

public class GdtMvNewTitleFactory
  implements IGdtMvTitleFactory
{
  private final String a = "GdtMvNewTitleFactory";
  private TextView b;
  private ImageView c;
  
  public void a(long paramLong1, long paramLong2, long paramLong3)
  {
    String str;
    if (paramLong1 > 0L) {
      str = String.format(HardCodeUtil.a(2131889962), new Object[] { Long.valueOf(paramLong2) });
    } else {
      str = HardCodeUtil.a(2131889961);
    }
    GdtMvTitleUtil.a(this.b, str, 0);
  }
  
  public void a(Context paramContext, boolean paramBoolean)
  {
    if (this.c == null)
    {
      QLog.i("GdtMvNewTitleFactory", 1, "refreshVoiceIconDrawableInner return");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("refreshVoiceIconDrawableInner ");
    localStringBuilder.append(paramBoolean);
    QLog.i("GdtMvNewTitleFactory", 1, localStringBuilder.toString());
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
    paramViewGroup.addView(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131624951, paramViewGroup, false));
    this.b = ((TextView)paramViewGroup.findViewById(2131434359));
    this.c = ((ImageView)paramViewGroup.findViewById(2131434360));
    paramGdtMvTitleHelper.a = this.c;
    paramGdtMvTitleHelper.a.setOnClickListener(paramGdtMvTitleHelper);
    paramGdtMvTitleHelper.b = paramViewGroup.findViewById(2131434358);
    paramGdtMvTitleHelper.b.setOnClickListener(paramGdtMvTitleHelper);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.basics.motivevideo.title.GdtMvNewTitleFactory
 * JD-Core Version:    0.7.0.1
 */