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
import android.widget.Toast;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
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

public class bmwo
  extends bmwj<bmvw>
  implements View.OnClickListener
{
  private bmwk<String, Drawable> a;
  
  public bmwo(Context paramContext, FaceListPage paramFaceListPage)
  {
    super(paramContext, paramFaceListPage);
    this.jdField_a_of_type_Bmwk = new bmwk();
  }
  
  private void a(Drawable paramDrawable, String paramString1, String paramString2, int paramInt)
  {
    paramDrawable = new bmrr(((bmvw)this.jdField_a_of_type_Bmvv).b, paramString2, paramDrawable, paramInt);
    paramString2 = blzk.a();
    this.jdField_a_of_type_Blsr.b(paramDrawable, paramString2.jdField_a_of_type_Int, paramString2.b, (float)((bmvw)this.jdField_a_of_type_Bmvv).jdField_a_of_type_Double, paramString1, null);
  }
  
  private void a(bmvz parambmvz)
  {
    int j = 7;
    String str = blvo.b(parambmvz);
    Object localObject1 = ".apng";
    if ((this.jdField_a_of_type_AndroidContentContext instanceof EditPicActivity)) {
      localObject1 = ".bpng";
    }
    for (int i = 0;; i = 1)
    {
      int k;
      if (parambmvz.jdField_a_of_type_Int == 8)
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
          localObject2 = (Drawable)this.jdField_a_of_type_Bmwk.a(str);
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
          this.jdField_a_of_type_Bmwk.a(str, localObject1);
          localObject2 = localObject1;
        }
        for (;;)
        {
          if (localObject2 == null) {
            break label452;
          }
          ((Drawable)localObject2).setBounds(0, 0, ((Drawable)localObject2).getIntrinsicWidth(), ((Drawable)localObject2).getIntrinsicHeight());
          a((Drawable)localObject2, str, parambmvz.b, i);
          return;
          label299:
          localObject1 = bduc.a(BaseApplicationImpl.sApplication.getRuntime(), str, "-Dynamic-", null, new int[] { 13 }, "-Dynamic-", null);
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
                ((URLDrawable)localObject1).setURLDrawableListener(new bmwp(this, str, parambmvz));
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
          this.jdField_a_of_type_Bmwk.a();
        }
        label452:
        wxe.e("InformationFaceAdapter", "can create drawable from path:" + str);
        return;
        label478:
        j = k;
      }
    }
  }
  
  private void a(Boolean paramBoolean, bmvz parambmvz)
  {
    if ((paramBoolean != null) && (paramBoolean.booleanValue()))
    {
      if (parambmvz.jdField_a_of_type_Int == 8) {
        a(parambmvz);
      }
    }
    else {
      return;
    }
    if ((bmwa.a(parambmvz.jdField_a_of_type_Int)) && ("default".equals(((bmvw)this.jdField_a_of_type_Bmvv).g)))
    {
      Toast.makeText(BaseApplicationImpl.getContext(), 2131700069, 0).show();
      return;
    }
    float f = (float)((bmvw)this.jdField_a_of_type_Bmvv).jdField_a_of_type_Double;
    paramBoolean = blzk.a();
    this.jdField_a_of_type_Blsr.a(parambmvz, null, paramBoolean.jdField_a_of_type_Int, paramBoolean.b, f);
  }
  
  private void a(String paramString)
  {
    ThreadManager.getFileThreadHandler().post(new InformationFaceAdapter.2(this, paramString));
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, 0, alud.a(2131706153), 0).a();
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_Bmvv == null) {
      return paramView;
    }
    if (paramView == null) {}
    for (paramView = new bmwr(this.jdField_a_of_type_AndroidContentContext, paramViewGroup.getWidth(), ((bmvw)this.jdField_a_of_type_Bmvv).a(), ((bmvw)this.jdField_a_of_type_Bmvv).a(), this, this);; paramView = (bmwr)paramView) {
      try
      {
        paramView.a((bmvw)this.jdField_a_of_type_Bmvv, paramInt, getCount(), a());
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
    ImageView localImageView = (ImageView)paramView.findViewById(2131368326);
    QIMCommonLoadingView localQIMCommonLoadingView = (QIMCommonLoadingView)paramView.findViewById(2131368325);
    int i = ((Integer)localImageView.getTag(2131377441)).intValue();
    bmvz localbmvz = (bmvz)((bmvw)this.jdField_a_of_type_Bmvv).jdField_a_of_type_JavaUtilList.get(i);
    Boolean localBoolean = (Boolean)localImageView.getTag(2131377419);
    blvo localblvo = (blvo)blqr.a().c(12);
    if (localblvo.a(localbmvz)) {
      a(localBoolean, localbmvz);
    }
    for (;;)
    {
      wxj.a((Activity)paramView.getContext(), "sticker_element", ((bmvw)this.jdField_a_of_type_Bmvv).jdField_a_of_type_JavaLangString, localbmvz.jdField_a_of_type_JavaLangString);
      return;
      if (bdin.g(paramView.getContext())) {
        localblvo.a((bmvz)((bmvw)this.jdField_a_of_type_Bmvv).jdField_a_of_type_JavaUtilList.get(i), new bmwq(this, localQIMCommonLoadingView, localImageView));
      } else {
        QQToast.a(paramView.getContext(), 0, alud.a(2131706155), 0).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmwo
 * JD-Core Version:    0.7.0.1
 */