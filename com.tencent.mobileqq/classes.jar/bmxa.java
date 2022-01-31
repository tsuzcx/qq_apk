import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;

class bmxa
  extends LinearLayout
{
  private int jdField_a_of_type_Int;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private bmwj jdField_a_of_type_Bmwj;
  private int b;
  private int c;
  private int d;
  
  public bmxa(Context paramContext, int paramInt1, int paramInt2, float paramFloat, View.OnClickListener paramOnClickListener, bmwj parambmwj)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.jdField_a_of_type_Bmwj = parambmwj;
    paramInt1 /= this.b;
    this.c = ((int)(paramInt1 * paramFloat));
    this.d = (paramInt1 - this.c * 2);
    a();
  }
  
  private void a()
  {
    int i = 0;
    setOrientation(0);
    setGravity(17);
    int j = this.jdField_a_of_type_Int / this.b;
    while (i < this.b)
    {
      URLImageView localURLImageView = new URLImageView(getContext());
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(j, j);
      if (i == 0) {
        localLayoutParams.leftMargin = bmyg.b(getContext(), 7.0F);
      }
      if (i == this.b - 1) {
        localLayoutParams.rightMargin = bmyg.b(getContext(), 7.0F);
      }
      localURLImageView.setLayoutParams(localLayoutParams);
      localURLImageView.setPadding(this.c, this.c, this.c, this.c);
      localURLImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      addView(localURLImageView);
      i += 1;
    }
  }
  
  private void a(int paramInt)
  {
    int i = 0;
    int j;
    for (;;)
    {
      j = paramInt;
      if (i >= paramInt) {
        break;
      }
      j = paramInt;
      if (i >= getChildCount()) {
        break;
      }
      getChildAt(i).setVisibility(0);
      i += 1;
    }
    while ((j < this.b) && (j < getChildCount()))
    {
      getChildAt(j).setVisibility(4);
      j += 1;
    }
  }
  
  public void a(bmwf parambmwf, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int i = paramInt1 * this.b;
    label31:
    ImageView localImageView;
    Object localObject;
    if (paramInt1 == paramInt2 - 1)
    {
      paramInt1 = parambmwf.b();
      a(paramInt1 - i);
      paramInt2 = i;
      if (paramInt2 >= paramInt1) {
        return;
      }
      localImageView = (ImageView)getChildAt(paramInt2 - i);
      localImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      localObject = parambmwf.a(paramInt2);
      localImageView.setTag(2131377450, localObject);
      localImageView.setTag(2131377441, Integer.valueOf(paramInt2));
      if (parambmwf.a(paramInt2) != 1) {
        break label252;
      }
      if (!(getContext() instanceof EditPicActivity)) {
        break label158;
      }
      localObject = parambmwf.b(paramInt2);
      localImageView.setTag(2131377450, localObject);
      bmrt.a().a(localImageView, (String)localObject, this.d, this.d, paramBoolean);
    }
    for (;;)
    {
      paramInt2 += 1;
      break label31;
      paramInt1 = this.b + i;
      break;
      label158:
      localObject = Uri.parse((String)localObject).getPath();
      localObject = bduc.a(BaseApplicationImpl.sApplication.getRuntime(), (String)localObject, "-Dynamic-", null, new int[] { 13 }, "-Dynamic-", null);
      if (localObject != null)
      {
        if (((URLDrawable)localObject).getStatus() == 2) {
          ((URLDrawable)localObject).restartDownload();
        }
        if (paramBoolean) {}
        for (;;)
        {
          localImageView.setImageDrawable((Drawable)localObject);
          break;
          localObject = null;
        }
      }
      if (QLog.isColorLevel())
      {
        QLog.d("NormalFaceAdapter", 2, "urlDrawable apng error");
        continue;
        label252:
        bmrt.a().a(localImageView, (String)localObject, this.d, this.d, paramBoolean);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmxa
 * JD-Core Version:    0.7.0.1
 */