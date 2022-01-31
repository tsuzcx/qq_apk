import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.view.QIMCommonLoadingView;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.FaceListPage;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter.InformationFaceAdapter.2;
import java.io.File;
import java.net.MalformedURLException;
import java.util.Calendar;
import java.util.List;
import mqq.os.MqqHandler;

public class bipg
  extends bipb<bioo>
  implements View.OnClickListener
{
  private bipc<String, Drawable> a;
  
  public bipg(Context paramContext, FaceListPage paramFaceListPage)
  {
    super(paramContext, paramFaceListPage);
    this.jdField_a_of_type_Bipc = new bipc();
  }
  
  private void a(Drawable paramDrawable, String paramString1, String paramString2, int paramInt)
  {
    paramDrawable = new bikj(((bioo)this.jdField_a_of_type_Bion).b, paramString2, paramDrawable, paramInt);
    paramString2 = bhoe.a();
    this.jdField_a_of_type_Bhhl.b(paramDrawable, paramString2.jdField_a_of_type_Int, paramString2.b, (float)((bioo)this.jdField_a_of_type_Bion).jdField_a_of_type_Double, paramString1, null);
  }
  
  private void a(ImageView paramImageView, Boolean paramBoolean, bior parambior)
  {
    if ((paramBoolean != null) && (paramBoolean.booleanValue()))
    {
      if (parambior.jdField_a_of_type_Int == 8) {
        a(parambior);
      }
    }
    else {
      return;
    }
    float f = (float)((bioo)this.jdField_a_of_type_Bion).jdField_a_of_type_Double;
    paramImageView = bhoe.a();
    this.jdField_a_of_type_Bhhl.a(parambior, null, paramImageView.jdField_a_of_type_Int, paramImageView.b, f);
  }
  
  private void a(bior parambior)
  {
    int j = 7;
    String str = bhki.b(parambior);
    Object localObject1 = ".apng";
    if ((this.jdField_a_of_type_AndroidContentContext instanceof EditPicActivity)) {
      localObject1 = ".bpng";
    }
    for (int i = 0;; i = 1)
    {
      int k;
      if (parambior.jdField_a_of_type_Int == 8)
      {
        k = Calendar.getInstance().get(7) - 1;
        if (k != 0) {
          break label478;
        }
      }
      for (;;)
      {
        for (str = str + File.separator + j + (String)localObject1;; str = str + File.separator + "city" + (String)localObject1)
        {
          localObject2 = (Drawable)this.jdField_a_of_type_Bipc.a(str);
          if (localObject2 != null) {
            break label442;
          }
          if (i == 1) {
            break label299;
          }
          localObject1 = BitmapFactory.decodeFile(str);
          if (localObject1 != null) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.e("InformationFaceAdapter", 2, "InformationFaceAdapter decodeFile path:" + str + ",bitmap is null");
          }
          a(str);
          return;
        }
        ((Bitmap)localObject1).setDensity(this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().densityDpi);
        localObject1 = new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), (Bitmap)localObject1);
        Object localObject2 = localObject1;
        if (localObject1 != null)
        {
          this.jdField_a_of_type_Bipc.a(str, localObject1);
          localObject2 = localObject1;
        }
        for (;;)
        {
          if (localObject2 == null) {
            break label452;
          }
          ((Drawable)localObject2).setBounds(0, 0, ((Drawable)localObject2).getIntrinsicWidth(), ((Drawable)localObject2).getIntrinsicHeight());
          a((Drawable)localObject2, str, parambior.b, i);
          return;
          label299:
          localObject1 = baop.a(BaseApplicationImpl.sApplication.getRuntime(), str, "-Dynamic-", null, new int[] { 13 }, "-Dynamic-", null);
          if (localObject1 != null)
          {
            j = ((URLDrawable)localObject1).getStatus();
            if (j != 1)
            {
              if (QLog.isColorLevel()) {
                QLog.e("InformationFaceAdapter", 2, "urlDrawable is not  SUCCESSED :" + j);
              }
              if (j == 2) {
                ((URLDrawable)localObject1).restartDownload();
              }
              for (;;)
              {
                ((URLDrawable)localObject1).setURLDrawableListener(new biph(this, str, parambior));
                localObject1 = localObject2;
                break;
                ((URLDrawable)localObject1).startDownload();
              }
            }
            break;
          }
          localObject1 = localObject2;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("InformationFaceAdapter", 2, "urlDrawable apng error");
          localObject1 = localObject2;
          break;
          label442:
          this.jdField_a_of_type_Bipc.a();
        }
        label452:
        urk.e("InformationFaceAdapter", "can create drawable from path:" + str);
        return;
        label478:
        j = k;
      }
    }
  }
  
  private void a(String paramString)
  {
    ThreadManager.getFileThreadHandler().post(new InformationFaceAdapter.2(this, paramString));
    bbmy.a(this.jdField_a_of_type_AndroidContentContext, 0, ajjy.a(2131639973), 0).a();
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_Bion == null) {
      return paramView;
    }
    if (paramView == null) {}
    for (paramView = new bipj(this.jdField_a_of_type_AndroidContentContext, paramViewGroup.getWidth(), ((bioo)this.jdField_a_of_type_Bion).a(), ((bioo)this.jdField_a_of_type_Bion).a(), this, this);; paramView = (bipj)paramView) {
      try
      {
        paramView.a((bioo)this.jdField_a_of_type_Bion, paramInt, getCount(), a());
        return paramView;
      }
      catch (MalformedURLException paramViewGroup)
      {
        paramViewGroup.printStackTrace();
        return paramView;
      }
    }
  }
  
  public void onClick(View paramView)
  {
    ImageView localImageView = (ImageView)paramView.findViewById(2131302549);
    QIMCommonLoadingView localQIMCommonLoadingView = (QIMCommonLoadingView)paramView.findViewById(2131302548);
    int i = ((Integer)localImageView.getTag(2131311062)).intValue();
    bior localbior = (bior)((bioo)this.jdField_a_of_type_Bion).jdField_a_of_type_JavaUtilList.get(i);
    Boolean localBoolean = (Boolean)localImageView.getTag(2131311040);
    bhki localbhki = (bhki)bhfm.a().c(12);
    if (localbhki.a(localbior)) {
      a(localImageView, localBoolean, localbior);
    }
    for (;;)
    {
      urp.a((Activity)paramView.getContext(), "sticker_element", ((bioo)this.jdField_a_of_type_Bion).jdField_a_of_type_JavaLangString, localbior.jdField_a_of_type_JavaLangString);
      return;
      if (badq.g(paramView.getContext())) {
        localbhki.a((bior)((bioo)this.jdField_a_of_type_Bion).jdField_a_of_type_JavaUtilList.get(i), new bipi(this, localQIMCommonLoadingView, localImageView));
      } else {
        bbmy.a(paramView.getContext(), 0, ajjy.a(2131639975), 0).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bipg
 * JD-Core Version:    0.7.0.1
 */