import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.qphone.base.util.QLog;

class amfh
  implements aoog
{
  protected aoof a;
  boolean jdField_a_of_type_Boolean = true;
  
  public amfh(amez paramamez, Context paramContext, AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_Aoof = new aoof(paramContext, paramAppInterface);
    this.jdField_a_of_type_Aoof.a(this);
  }
  
  private Bitmap a(String paramString, int paramInt1, byte paramByte, int paramInt2)
  {
    Object localObject;
    if (this.jdField_a_of_type_Aoof == null) {
      localObject = null;
    }
    Bitmap localBitmap;
    do
    {
      return localObject;
      localBitmap = this.jdField_a_of_type_Aoof.b(paramInt1, paramString, paramInt2);
      localObject = localBitmap;
    } while (localBitmap != null);
    QLog.w("FriendTeamListInnerFrameBuddyListAdapter", 1, "requestDecodeFace, uin[" + paramString + "]");
    this.jdField_a_of_type_Aoof.a(paramString, paramInt1, true, paramByte);
    return bhmq.a();
  }
  
  public Bitmap a(TroopMemberInfo paramTroopMemberInfo)
  {
    return a(paramTroopMemberInfo.memberuin, 1, (byte)0, 0);
  }
  
  public void a()
  {
    try
    {
      if (this.jdField_a_of_type_Aoof != null)
      {
        this.jdField_a_of_type_Aoof.d();
        this.jdField_a_of_type_Aoof = null;
      }
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.jdField_a_of_type_Aoof = null;
      }
    }
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    QLog.w("FriendTeamListInnerFrameBuddyListAdapter", 1, "onDecodeTaskCompleted, uin[" + paramString + "]");
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    amez.a(this.jdField_a_of_type_Amez, paramString, paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amfh
 * JD-Core Version:    0.7.0.1
 */