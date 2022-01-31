package com.tencent.mobileqq.activity.qwallet.goldmsg;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.widget.ButtonInfo;
import com.tencent.mobileqq.nearby.widget.NearbyCustomDialog;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import xkn;
import xko;

public class GoldMsgDialog
  extends NearbyCustomDialog
  implements DialogInterface.OnDismissListener
{
  private ImageView b;
  
  public GoldMsgDialog(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public static Bitmap a(Bitmap paramBitmap, float paramFloat, boolean paramBoolean)
  {
    if (paramBitmap == null) {
      return null;
    }
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    Bitmap localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    Paint localPaint = new Paint();
    Rect localRect = new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
    RectF localRectF = new RectF(localRect);
    localPaint.setAntiAlias(true);
    localCanvas.drawARGB(0, 0, 0, 0);
    localCanvas.drawRoundRect(localRectF, paramFloat, paramFloat, localPaint);
    if (paramBoolean) {
      localCanvas.drawRect(new Rect(0, (int)(j - paramFloat), i, j), localPaint);
    }
    localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    localCanvas.drawBitmap(paramBitmap, localRect, localRect, localPaint);
    return localBitmap;
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(20.0F);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(16.0F);
    setOnDismissListener(this);
  }
  
  public GoldMsgDialog a(View paramView, LinearLayout.LayoutParams paramLayoutParams)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramView, this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount(), paramLayoutParams);
    return this;
  }
  
  public GoldMsgDialog a(ButtonInfo paramButtonInfo)
  {
    Button localButton = new Button(getContext());
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    localLayoutParams.topMargin = UIUtils.a(getContext(), 10.0F);
    Object localObject;
    if (paramButtonInfo.jdField_a_of_type_JavaLangString != null)
    {
      localObject = paramButtonInfo.jdField_a_of_type_JavaLangString;
      localButton.setText((CharSequence)localObject);
      localButton.setTextSize(18.0F);
      if (paramButtonInfo.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
        break label134;
      }
      localObject = paramButtonInfo.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      label76:
      localButton.setBackgroundDrawable((Drawable)localObject);
      if (paramButtonInfo.jdField_a_of_type_Int == -1) {
        break label150;
      }
    }
    label134:
    label150:
    for (int i = paramButtonInfo.jdField_a_of_type_Int;; i = -1)
    {
      localButton.setTextColor(i);
      localButton.setOnClickListener(new xkn(this, paramButtonInfo));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localButton, localLayoutParams);
      return this;
      localObject = "";
      break;
      localObject = getContext().getResources().getDrawable(2130838497);
      break label76;
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_b_of_type_AndroidWidgetImageView = new ImageView(getContext());
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    Object localObject = new RelativeLayout.LayoutParams(-1, -2);
    a(this.jdField_b_of_type_AndroidWidgetImageView, (RelativeLayout.LayoutParams)localObject);
    localObject = BaseApplicationImpl.getApplication().getRuntime();
    if (localObject == null) {
      return;
    }
    PreloadManager localPreloadManager = (PreloadManager)((AppRuntime)localObject).getManager(150);
    localPreloadManager.c(paramString);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    ThreadManager.post(new xko(this, localPreloadManager, localArrayList, (AppRuntime)localObject), 5, null, true);
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (this.jdField_b_of_type_AndroidWidgetImageView != null)
    {
      paramDialogInterface = this.jdField_b_of_type_AndroidWidgetImageView.getDrawable();
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(null);
      if ((paramDialogInterface != null) && ((paramDialogInterface instanceof BitmapDrawable)))
      {
        paramDialogInterface = (BitmapDrawable)paramDialogInterface;
        if ((paramDialogInterface.getBitmap() != null) && (!paramDialogInterface.getBitmap().isRecycled())) {
          paramDialogInterface.getBitmap().recycle();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.goldmsg.GoldMsgDialog
 * JD-Core Version:    0.7.0.1
 */