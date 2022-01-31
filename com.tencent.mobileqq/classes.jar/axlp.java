import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.ResultReceiver;
import android.util.SparseArray;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public abstract class axlp
  extends axlo
{
  public ResultReceiver a;
  
  public static axlp a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return null;
    }
    int i = paramBundle.getInt("redpoint.fromReceiverIPCCode", -1);
    Object localObject = (Class)jdField_a_of_type_AndroidUtilSparseArray.get(i);
    if (localObject != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BaseReq getReq", 2, "class name is " + ((Class)localObject).getName());
      }
      try
      {
        localObject = (axlp)((Class)localObject).newInstance();
        ((axlp)localObject).b(paramBundle);
        return localObject;
      }
      catch (Exception paramBundle)
      {
        return null;
      }
    }
    return null;
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    if (this.jdField_a_of_type_AndroidOsResultReceiver != null)
    {
      Parcel localParcel = Parcel.obtain();
      this.jdField_a_of_type_AndroidOsResultReceiver.writeToParcel(localParcel, 0);
      localParcel.setDataPosition(0);
      ResultReceiver localResultReceiver = (ResultReceiver)ResultReceiver.CREATOR.createFromParcel(localParcel);
      localParcel.recycle();
      paramBundle.putParcelable("redpoint.fromReceiverKey", localResultReceiver);
    }
  }
  
  public abstract void a(QQAppInterface paramQQAppInterface, Bundle paramBundle);
  
  public final boolean a(Bundle paramBundle)
  {
    if ((paramBundle == null) || (this.jdField_a_of_type_AndroidOsResultReceiver == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("BaseReq doCallback", 2, "bundle == null or fromReceiver == null");
      }
      return false;
    }
    this.jdField_a_of_type_AndroidOsResultReceiver.send(0, paramBundle);
    return true;
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    this.jdField_a_of_type_AndroidOsResultReceiver = ((ResultReceiver)paramBundle.getParcelable("redpoint.fromReceiverKey"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     axlp
 * JD-Core Version:    0.7.0.1
 */