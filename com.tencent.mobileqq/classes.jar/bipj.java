import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.ApngDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.view.QIMCommonLoadingView;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

public class bipj
  extends LinearLayout
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private bipb jdField_a_of_type_Bipb;
  private int b;
  private int c;
  
  public bipj(Context paramContext, int paramInt1, int paramInt2, float paramFloat, View.OnClickListener paramOnClickListener, bipb parambipb)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.jdField_a_of_type_Float = paramFloat;
    this.jdField_a_of_type_Bipb = parambipb;
    paramInt1 = biqy.a(getContext(), 6.0F);
    this.jdField_c_of_type_Int = ((this.jdField_a_of_type_Int - paramInt1 * ((this.b - 1) * 2)) / this.b);
    a();
  }
  
  private URLDrawable a(bior parambior)
  {
    Object localObject1 = (bhki)bhfm.a().c(12);
    Object localObject2 = bhki.a();
    localObject1 = parambior.b + "_static.png";
    localObject2 = new File((String)localObject2);
    if (((File)localObject2).exists()) {
      if (!((File)localObject2).isDirectory()) {
        ((File)localObject2).delete();
      }
    }
    for (;;)
    {
      localObject1 = new File((File)localObject2, (String)localObject1);
      if (QLog.isColorLevel()) {
        QLog.d("InformationFaceAdapter", 2, "static file name:" + ((File)localObject1).getAbsolutePath());
      }
      parambior = new URL(parambior.d);
      localObject1 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject1).Recycle();
      ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = axwd.a;
      ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = axwd.a;
      return URLDrawable.getDrawable(parambior, (URLDrawable.URLDrawableOptions)localObject1);
      ((File)localObject2).mkdirs();
    }
  }
  
  private void a()
  {
    setOrientation(0);
    setGravity(17);
    int j = biqy.a(getContext(), 12.0F);
    int k = (int)((this.jdField_c_of_type_Int - j * 2) * this.jdField_a_of_type_Float);
    int i = 0;
    if (i < this.b)
    {
      View localView = LayoutInflater.from(getContext()).inflate(2131495685, null);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(this.jdField_c_of_type_Int, this.jdField_c_of_type_Int);
      if (i == 0) {
        localLayoutParams.setMargins(0, j, j / 2, 0);
      }
      for (;;)
      {
        localView.setLayoutParams(localLayoutParams);
        ((ImageView)localView.findViewById(2131302549)).setPadding(k, k, k, k);
        addView(localView);
        i += 1;
        break;
        if (this.b - 1 == i) {
          localLayoutParams.setMargins(j / 2, j, 0, 0);
        } else {
          localLayoutParams.setMargins(j / 2, j, j / 2, 0);
        }
      }
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
  
  private void a(bior parambior, URLImageView paramURLImageView, QIMCommonLoadingView paramQIMCommonLoadingView, ProgressBar paramProgressBar, bipl parambipl, boolean paramBoolean, bipb parambipb)
  {
    Object localObject1 = (bhki)bhfm.a().c(12);
    Object localObject2 = bhki.a();
    localObject1 = parambior.b + "_dynamic.png";
    localObject2 = new File((String)localObject2);
    String str;
    if (((File)localObject2).exists())
    {
      if (!((File)localObject2).isDirectory()) {
        ((File)localObject2).delete();
      }
      localObject2 = new File((File)localObject2, (String)localObject1);
      if (QLog.isColorLevel()) {
        QLog.d("InformationFaceAdapter", 2, "apng file name:" + ((File)localObject2).getAbsolutePath());
      }
      str = ((File)localObject2).getAbsolutePath();
      bool2 = false;
      bool1 = false;
      if (!((File)localObject2).exists()) {}
    }
    for (;;)
    {
      try
      {
        bool1 = ApngDrawable.isApngFile((File)localObject2);
        if (!bool1) {}
      }
      catch (IOException localIOException2)
      {
        label227:
        bool1 = bool2;
        continue;
        if (!paramBoolean) {
          continue;
        }
        continue;
      }
      try
      {
        localObject1 = baop.a(BaseApplicationImpl.sApplication.getRuntime(), ((File)localObject2).getAbsolutePath(), "-Dynamic-", axwd.a, new int[] { 13 }, "-Dynamic-", null);
        if (localObject1 == null) {
          continue;
        }
        if (((URLDrawable)localObject1).getStatus() != 1) {
          ((URLDrawable)localObject1).restartDownload();
        }
        if (((URLDrawable)localObject1).getStatus() != 1) {
          continue;
        }
        parambipl.onLoadSuccessed(paramURLImageView, (URLDrawable)localObject1);
      }
      catch (IOException localIOException1)
      {
        localIOException1.printStackTrace();
      }
    }
    paramURLImageView.setImageDrawable((Drawable)localObject1);
    for (;;)
    {
      if (!bool1)
      {
        paramURLImageView = new java.lang.ref.WeakReference(paramURLImageView);
        paramQIMCommonLoadingView = new java.lang.ref.WeakReference(paramQIMCommonLoadingView);
        paramProgressBar = new mqq.util.WeakReference(paramProgressBar);
        new java.lang.ref.WeakReference(parambipb);
        parambipb = parambior.jdField_c_of_type_JavaLangString;
        localObject1 = new axro();
        ((axro)localObject1).jdField_a_of_type_Axrt = new bipk(this, (File)localObject2, paramQIMCommonLoadingView, paramURLImageView, str, paramBoolean, parambipl, paramProgressBar);
        ((axro)localObject1).jdField_a_of_type_JavaLangString = parambipb;
        if (QLog.isColorLevel()) {
          QLog.d("InformationFaceAdapter", 2, "apng url:" + parambipb);
        }
        ((axro)localObject1).jdField_a_of_type_Int = 0;
        ((axro)localObject1).jdField_c_of_type_JavaLangString = ((File)localObject2).getAbsolutePath();
        ((axro)localObject1).jdField_c_of_type_Int = badq.a(axsr.a().a());
        ((axro)localObject1).a(parambior);
        kry.a().a((axsp)localObject1);
      }
      return;
      ((File)localObject2).mkdirs();
      break;
      localObject1 = null;
      break label227;
      if (QLog.isColorLevel()) {
        QLog.d("InformationFaceAdapter", 2, "apng invalid file:" + ((File)localObject2).getAbsolutePath());
      }
      ((File)localObject2).delete();
    }
  }
  
  public void a(bioo parambioo, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int i = paramInt1 * this.b;
    label31:
    Object localObject1;
    Object localObject2;
    URLImageView localURLImageView;
    ProgressBar localProgressBar;
    QIMCommonLoadingView localQIMCommonLoadingView;
    if (paramInt1 == paramInt2 - 1)
    {
      paramInt1 = parambioo.b();
      a(paramInt1 - i);
      paramInt2 = i;
      if (paramInt2 >= paramInt1) {
        return;
      }
      localObject1 = getChildAt(paramInt2 - i);
      localObject2 = ((View)localObject1).findViewById(2131302551);
      localURLImageView = (URLImageView)((View)localObject1).findViewById(2131302549);
      localProgressBar = (ProgressBar)((View)localObject1).findViewById(2131302550);
      localQIMCommonLoadingView = (QIMCommonLoadingView)((View)localObject1).findViewById(2131302548);
      if (!(this.jdField_a_of_type_AndroidContentContext instanceof EditPicActivity)) {
        break label153;
      }
      localObject1 = parambioo.b(paramInt2);
      label111:
      if (localObject1 != null) {
        break label163;
      }
      urk.e("InformationFaceAdapter", "FacePackage's thumbUri is empty , pkg : %s", new Object[] { parambioo.toString() });
    }
    for (;;)
    {
      paramInt2 += 1;
      break label31;
      paramInt1 = this.b + i;
      break;
      label153:
      localObject1 = parambioo.a(paramInt2);
      break label111;
      label163:
      ((View)localObject2).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      localURLImageView.setTag(2131311062, Integer.valueOf(paramInt2));
      if (!paramBoolean)
      {
        localProgressBar.setVisibility(4);
        localURLImageView.setImageDrawable(null);
      }
      else
      {
        localURLImageView.setTag(2131311070, localObject1);
        localURLImageView.setTag(2131311040, Boolean.valueOf(false));
        localProgressBar.setVisibility(0);
        localObject2 = new bipl((String)localObject1, localURLImageView, localProgressBar);
        localURLImageView.setURLDrawableDownListener((URLDrawableDownListener)localObject2);
        if ((this.jdField_a_of_type_AndroidContentContext instanceof EditPicActivity))
        {
          localObject1 = a((bior)parambioo.a.get(paramInt2));
          if (localObject1 != null)
          {
            if (((URLDrawable)localObject1).getStatus() != 1) {
              ((URLDrawable)localObject1).restartDownload();
            }
            if (((URLDrawable)localObject1).getStatus() == 1) {
              ((bipl)localObject2).onLoadSuccessed(localURLImageView, (URLDrawable)localObject1);
            }
            if (paramBoolean) {}
            for (;;)
            {
              localURLImageView.setImageDrawable((Drawable)localObject1);
              break;
              localObject1 = null;
            }
          }
        }
        else
        {
          a((bior)parambioo.a.get(paramInt2), localURLImageView, localQIMCommonLoadingView, localProgressBar, (bipl)localObject2, paramBoolean, this.jdField_a_of_type_Bipb);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bipj
 * JD-Core Version:    0.7.0.1
 */