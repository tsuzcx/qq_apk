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

public class bmsc
  extends bmrx<bmrk>
  implements View.OnClickListener
{
  private bmry<String, Drawable> a;
  
  public bmsc(Context paramContext, FaceListPage paramFaceListPage)
  {
    super(paramContext, paramFaceListPage);
    this.jdField_a_of_type_Bmry = new bmry();
  }
  
  private void a(Drawable paramDrawable, String paramString1, String paramString2, int paramInt)
  {
    paramDrawable = new bmnf(((bmrk)this.jdField_a_of_type_Bmrj).b, paramString2, paramDrawable, paramInt);
    paramString2 = bluy.a();
    this.jdField_a_of_type_Blof.b(paramDrawable, paramString2.jdField_a_of_type_Int, paramString2.b, (float)((bmrk)this.jdField_a_of_type_Bmrj).jdField_a_of_type_Double, paramString1, null);
  }
  
  private void a(bmrn parambmrn)
  {
    int j = 7;
    String str = blrc.b(parambmrn);
    Object localObject1 = ".apng";
    if ((this.jdField_a_of_type_AndroidContentContext instanceof EditPicActivity)) {
      localObject1 = ".bpng";
    }
    for (int i = 0;; i = 1)
    {
      int k;
      if (parambmrn.jdField_a_of_type_Int == 8)
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
          localObject2 = (Drawable)this.jdField_a_of_type_Bmry.a(str);
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
          this.jdField_a_of_type_Bmry.a(str, localObject1);
          localObject2 = localObject1;
        }
        for (;;)
        {
          if (localObject2 == null) {
            break label452;
          }
          ((Drawable)localObject2).setBounds(0, 0, ((Drawable)localObject2).getIntrinsicWidth(), ((Drawable)localObject2).getIntrinsicHeight());
          a((Drawable)localObject2, str, parambmrn.b, i);
          return;
          label299:
          localObject1 = bdpt.a(BaseApplicationImpl.sApplication.getRuntime(), str, "-Dynamic-", null, new int[] { 13 }, "-Dynamic-", null);
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
                ((URLDrawable)localObject1).setURLDrawableListener(new bmsd(this, str, parambmrn));
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
          this.jdField_a_of_type_Bmry.a();
        }
        label452:
        wsv.e("InformationFaceAdapter", "can create drawable from path:" + str);
        return;
        label478:
        j = k;
      }
    }
  }
  
  private void a(Boolean paramBoolean, bmrn parambmrn)
  {
    if ((paramBoolean != null) && (paramBoolean.booleanValue()))
    {
      if (parambmrn.jdField_a_of_type_Int == 8) {
        a(parambmrn);
      }
    }
    else {
      return;
    }
    if ((bmro.a(parambmrn.jdField_a_of_type_Int)) && ("default".equals(((bmrk)this.jdField_a_of_type_Bmrj).g)))
    {
      Toast.makeText(BaseApplicationImpl.getContext(), 2131700057, 0).show();
      return;
    }
    float f = (float)((bmrk)this.jdField_a_of_type_Bmrj).jdField_a_of_type_Double;
    paramBoolean = bluy.a();
    this.jdField_a_of_type_Blof.a(parambmrn, null, paramBoolean.jdField_a_of_type_Int, paramBoolean.b, f);
  }
  
  private void a(String paramString)
  {
    ThreadManager.getFileThreadHandler().post(new InformationFaceAdapter.2(this, paramString));
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, 0, alpo.a(2131706141), 0).a();
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_Bmrj == null) {
      return paramView;
    }
    if (paramView == null) {}
    for (paramView = new bmsf(this.jdField_a_of_type_AndroidContentContext, paramViewGroup.getWidth(), ((bmrk)this.jdField_a_of_type_Bmrj).a(), ((bmrk)this.jdField_a_of_type_Bmrj).a(), this, this);; paramView = (bmsf)paramView) {
      try
      {
        paramView.a((bmrk)this.jdField_a_of_type_Bmrj, paramInt, getCount(), a());
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
    ImageView localImageView = (ImageView)paramView.findViewById(2131368315);
    QIMCommonLoadingView localQIMCommonLoadingView = (QIMCommonLoadingView)paramView.findViewById(2131368314);
    int i = ((Integer)localImageView.getTag(2131377387)).intValue();
    bmrn localbmrn = (bmrn)((bmrk)this.jdField_a_of_type_Bmrj).jdField_a_of_type_JavaUtilList.get(i);
    Boolean localBoolean = (Boolean)localImageView.getTag(2131377365);
    blrc localblrc = (blrc)blmf.a().c(12);
    if (localblrc.a(localbmrn)) {
      a(localBoolean, localbmrn);
    }
    for (;;)
    {
      wta.a((Activity)paramView.getContext(), "sticker_element", ((bmrk)this.jdField_a_of_type_Bmrj).jdField_a_of_type_JavaLangString, localbmrn.jdField_a_of_type_JavaLangString);
      return;
      if (bdee.g(paramView.getContext())) {
        localblrc.a((bmrn)((bmrk)this.jdField_a_of_type_Bmrj).jdField_a_of_type_JavaUtilList.get(i), new bmse(this, localQIMCommonLoadingView, localImageView));
      } else {
        QQToast.a(paramView.getContext(), 0, alpo.a(2131706143), 0).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmsc
 * JD-Core Version:    0.7.0.1
 */