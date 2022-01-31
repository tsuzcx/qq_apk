import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.mobileqq.vas.VasApngUtil.ApngSoLoadCallBack;
import dov.com.qq.im.capture.view.QIMCommonLoadingView;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;

class aojn
  implements Runnable
{
  aojn(aojm paramaojm, boolean paramBoolean) {}
  
  public void run()
  {
    ((QIMCommonLoadingView)this.jdField_a_of_type_Aojm.jdField_a_of_type_JavaLangRefWeakReference.get()).setVisibility(8);
    ((ImageView)this.jdField_a_of_type_Aojm.b.get()).setVisibility(0);
    if (this.jdField_a_of_type_Boolean)
    {
      Object localObject1 = BaseApplicationImpl.sApplication.getRuntime();
      Object localObject2 = this.jdField_a_of_type_Aojm.jdField_a_of_type_JavaLangString;
      Object localObject3 = new aojo(this);
      localObject1 = VasApngUtil.a((AppRuntime)localObject1, (String)localObject2, "-Dynamic-", null, new int[] { 13 }, "-Dynamic-", null, (VasApngUtil.ApngSoLoadCallBack)localObject3);
      if (localObject1 != null)
      {
        localObject3 = (ImageView)this.jdField_a_of_type_Aojm.b.get();
        if (!this.jdField_a_of_type_Aojm.jdField_a_of_type_Boolean) {
          break label222;
        }
        localObject2 = localObject1;
        ((ImageView)localObject3).setImageDrawable((Drawable)localObject2);
        ((ImageView)this.jdField_a_of_type_Aojm.b.get()).setTag(2131362364, Boolean.valueOf(true));
        if (localObject1 != null)
        {
          if (((URLDrawable)localObject1).getStatus() != 1) {
            ((URLDrawable)localObject1).restartDownload();
          }
          if (((URLDrawable)localObject1).getStatus() == 1) {
            this.jdField_a_of_type_Aojm.jdField_a_of_type_Aojr.onLoadSuccessed((View)this.jdField_a_of_type_Aojm.b.get(), (URLDrawable)localObject1);
          }
          localObject2 = (ImageView)this.jdField_a_of_type_Aojm.b.get();
          if (!this.jdField_a_of_type_Aojm.jdField_a_of_type_Boolean) {
            break label227;
          }
        }
      }
      for (;;)
      {
        ((ImageView)localObject2).setImageDrawable((Drawable)localObject1);
        return;
        label222:
        localObject2 = null;
        break;
        label227:
        localObject1 = null;
      }
    }
    ((ImageView)this.jdField_a_of_type_Aojm.b.get()).setImageDrawable(URLDrawableHelper.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aojn
 * JD-Core Version:    0.7.0.1
 */