package com.tencent.aelight.camera.ae.view;

import android.app.Dialog;
import android.content.Context;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.widget.ProgressPieDrawable;

public class AECameraCancelableProgressDialog
  extends Dialog
{
  private ProgressPieDrawable a;
  private final TextView b;
  
  public AECameraCancelableProgressDialog(@NonNull Context paramContext)
  {
    super(paramContext, 2131953338);
    setCancelable(false);
    setCanceledOnTouchOutside(false);
    setContentView(2064056388);
    ((TextView)findViewById(2063991531)).setText(2131892582);
    paramContext = (ImageView)findViewById(2063991206);
    this.a = a();
    paramContext.setImageDrawable(this.a);
    this.b = ((TextView)findViewById(2063990915));
  }
  
  private ProgressPieDrawable a()
  {
    ProgressPieDrawable localProgressPieDrawable = new ProgressPieDrawable(getContext());
    localProgressPieDrawable.a(UIUtils.a(getContext(), 94.0F));
    localProgressPieDrawable.a(true);
    localProgressPieDrawable.h(-1711276033);
    localProgressPieDrawable.i(18);
    localProgressPieDrawable.b(true);
    localProgressPieDrawable.d(false);
    localProgressPieDrawable.g(0);
    localProgressPieDrawable.c(false);
    localProgressPieDrawable.e(-16722948);
    localProgressPieDrawable.f(872415231);
    localProgressPieDrawable.j(6);
    localProgressPieDrawable.e(true);
    localProgressPieDrawable.D = true;
    localProgressPieDrawable.A = 2;
    return localProgressPieDrawable;
  }
  
  public void a(int paramInt)
  {
    ProgressPieDrawable localProgressPieDrawable = this.a;
    if (localProgressPieDrawable == null) {
      return;
    }
    localProgressPieDrawable.b();
    this.a.d(paramInt);
    localProgressPieDrawable = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("%");
    localProgressPieDrawable.a(localStringBuilder.toString());
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.b.setOnClickListener(paramOnClickListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.view.AECameraCancelableProgressDialog
 * JD-Core Version:    0.7.0.1
 */