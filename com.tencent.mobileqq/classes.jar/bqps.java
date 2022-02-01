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
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.view.QIMCommonLoadingView;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

public class bqps
  extends LinearLayout
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private bqpk jdField_a_of_type_Bqpk;
  private int b;
  private int c;
  
  public bqps(Context paramContext, int paramInt1, int paramInt2, float paramFloat, View.OnClickListener paramOnClickListener, bqpk parambqpk)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.jdField_a_of_type_Float = paramFloat;
    this.jdField_a_of_type_Bqpk = parambqpk;
    paramInt1 = bqrh.b(getContext(), 6.0F);
    this.c = ((this.jdField_a_of_type_Int - paramInt1 * ((this.b - 1) * 2)) / this.b);
    a();
  }
  
  private URLDrawable a(bqpa parambqpa)
  {
    Object localObject1 = (bpqn)bplq.a().c(12);
    Object localObject2 = bpqn.a();
    localObject1 = parambqpa.b + "_static.png";
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
      parambqpa = new URL(parambqpa.d);
      localObject1 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject1).Recycle();
      ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = beyq.a;
      ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = beyq.a;
      return URLDrawable.getDrawable(parambqpa, (URLDrawable.URLDrawableOptions)localObject1);
      ((File)localObject2).mkdirs();
    }
  }
  
  private void a()
  {
    setOrientation(0);
    setGravity(17);
    int j = bqrh.b(getContext(), 12.0F);
    int k = (int)((this.c - j * 2) * this.jdField_a_of_type_Float);
    int i = 0;
    if (i < this.b)
    {
      View localView = LayoutInflater.from(getContext()).inflate(2131561759, null);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(this.c, this.c);
      if (i == 0) {
        localLayoutParams.setMargins(0, j, j / 2, 0);
      }
      for (;;)
      {
        localView.setLayoutParams(localLayoutParams);
        ((ImageView)localView.findViewById(2131368707)).setPadding(k, k, k, k);
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
  
  private void a(bqpa parambqpa, URLImageView paramURLImageView, QIMCommonLoadingView paramQIMCommonLoadingView, ProgressBar paramProgressBar, bqpu parambqpu, boolean paramBoolean, bqpk parambqpk)
  {
    Object localObject1 = (bpqn)bplq.a().c(12);
    Object localObject2 = bpqn.a();
    localObject1 = parambqpa.b + "_dynamic.png";
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
        localObject1 = VasApngUtil.getApngDrawable(BaseApplicationImpl.sApplication.getRuntime(), ((File)localObject2).getAbsolutePath(), "-Dynamic-", beyq.a, new int[] { 13 }, "-Dynamic-", null);
        if (localObject1 == null) {
          continue;
        }
        if (((URLDrawable)localObject1).getStatus() != 1) {
          ((URLDrawable)localObject1).restartDownload();
        }
        if (((URLDrawable)localObject1).getStatus() != 1) {
          continue;
        }
        parambqpu.onLoadSuccessed(paramURLImageView, (URLDrawable)localObject1);
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
        new java.lang.ref.WeakReference(parambqpk);
        parambqpk = parambqpa.c;
        localObject1 = new beum();
        ((beum)localObject1).jdField_a_of_type_Beuq = new bqpt(this, (File)localObject2, paramQIMCommonLoadingView, paramURLImageView, str, paramBoolean, parambqpu, paramProgressBar);
        ((beum)localObject1).jdField_a_of_type_JavaLangString = parambqpk;
        if (QLog.isColorLevel()) {
          QLog.d("InformationFaceAdapter", 2, "apng url:" + parambqpk);
        }
        ((beum)localObject1).jdField_a_of_type_Int = 0;
        ((beum)localObject1).c = ((File)localObject2).getAbsolutePath();
        ((beum)localObject1).b = bhnv.a(bevn.a().a());
        ((beum)localObject1).a(parambqpa);
        lbk.a().a((bevl)localObject1);
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
  
  public void a(bqox parambqox, int paramInt1, int paramInt2, boolean paramBoolean)
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
      paramInt1 = parambqox.b();
      a(paramInt1 - i);
      paramInt2 = i;
      if (paramInt2 >= paramInt1) {
        return;
      }
      localObject1 = getChildAt(paramInt2 - i);
      localObject2 = ((View)localObject1).findViewById(2131368709);
      localURLImageView = (URLImageView)((View)localObject1).findViewById(2131368707);
      localProgressBar = (ProgressBar)((View)localObject1).findViewById(2131368708);
      localQIMCommonLoadingView = (QIMCommonLoadingView)((View)localObject1).findViewById(2131368706);
      if (!(this.jdField_a_of_type_AndroidContentContext instanceof EditPicActivity)) {
        break label153;
      }
      localObject1 = parambqox.b(paramInt2);
      label111:
      if (localObject1 != null) {
        break label163;
      }
      yuk.e("InformationFaceAdapter", "FacePackage's thumbUri is empty , pkg : %s", new Object[] { parambqox.toString() });
    }
    for (;;)
    {
      paramInt2 += 1;
      break label31;
      paramInt1 = this.b + i;
      break;
      label153:
      localObject1 = parambqox.a(paramInt2);
      break label111;
      label163:
      ((View)localObject2).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      localURLImageView.setTag(2131378427, Integer.valueOf(paramInt2));
      if (!paramBoolean)
      {
        localProgressBar.setVisibility(4);
        localURLImageView.setImageDrawable(null);
      }
      else
      {
        localURLImageView.setTag(2131378440, localObject1);
        localURLImageView.setTag(2131378405, Boolean.valueOf(false));
        localProgressBar.setVisibility(0);
        localObject2 = new bqpu((String)localObject1, localURLImageView, localProgressBar);
        localURLImageView.setURLDrawableDownListener((URLDrawableDownListener)localObject2);
        if ((this.jdField_a_of_type_AndroidContentContext instanceof EditPicActivity))
        {
          localObject1 = a((bqpa)parambqox.a.get(paramInt2));
          if (localObject1 != null)
          {
            if (((URLDrawable)localObject1).getStatus() != 1) {
              ((URLDrawable)localObject1).restartDownload();
            }
            if (((URLDrawable)localObject1).getStatus() == 1) {
              ((bqpu)localObject2).onLoadSuccessed(localURLImageView, (URLDrawable)localObject1);
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
          a((bqpa)parambqox.a.get(paramInt2), localURLImageView, localQIMCommonLoadingView, localProgressBar, (bqpu)localObject2, paramBoolean, this.jdField_a_of_type_Bqpk);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqps
 * JD-Core Version:    0.7.0.1
 */