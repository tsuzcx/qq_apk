import android.app.Activity;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import java.lang.ref.WeakReference;

public class bquh
  extends bquq<bqua, bqua>
{
  private int a;
  public WeakReference<Activity> a;
  
  public bquh(@NonNull Activity paramActivity, int paramInt)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  protected void a(JobContext paramJobContext, bqua parambqua)
  {
    Activity localActivity = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localActivity == null)
    {
      yuk.e("Q.qqstory.publish.edit.GeneratePicThumbSegment", "ChangePicArgToVideoArgSegment, activity is null");
      super.notifyError(new ErrorMessage(-1, "ChangePicArgToVideoArgSegment error"));
      return;
    }
    Object localObject = parambqua.jdField_a_of_type_Bqug.jdField_a_of_type_JavaLangString;
    paramJobContext = (JobContext)localObject;
    if (!parambqua.jdField_a_of_type_Bqug.c)
    {
      paramJobContext = (JobContext)localObject;
      if (parambqua.jdField_a_of_type_Bqug.jdField_b_of_type_Boolean) {
        paramJobContext = parambqua.jdField_a_of_type_Bqug.jdField_b_of_type_JavaLangString;
      }
    }
    localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramJobContext, (BitmapFactory.Options)localObject);
    int i = ((BitmapFactory.Options)localObject).outWidth;
    int j = ((BitmapFactory.Options)localObject).outHeight;
    if (this.jdField_a_of_type_Int == 5) {}
    for (boolean bool = true;; bool = false)
    {
      parambqua.jdField_a_of_type_Bqui = new bqui(localActivity, i, j, paramJobContext, 0.0F, bool, 0, 0.0D, 0.0D, null, false);
      parambqua.jdField_a_of_type_JavaLangString = paramJobContext;
      super.notifyResult(parambqua);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bquh
 * JD-Core Version:    0.7.0.1
 */