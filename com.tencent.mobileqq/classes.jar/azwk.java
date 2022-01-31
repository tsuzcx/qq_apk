import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.GroupIconHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.util.FaceDecodeTask;
import com.tencent.mobileqq.util.FaceInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Hashtable;
import java.util.LinkedList;

public class azwk
  extends azwi
  implements azwd
{
  private azwm jdField_a_of_type_Azwm;
  private azwn jdField_a_of_type_Azwn;
  private azwo jdField_a_of_type_Azwo;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public azwk(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Int = 4;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public Bitmap a(int paramInt1, String paramString, int paramInt2, byte paramByte)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqhead.FaceDecoderImpl", 2, "getBitmapFromCache, mApp is null");
      }
      return null;
    }
    if ((paramInt1 == 1001) && (paramString != null) && (!GroupIconHelper.a(paramString))) {}
    for (Object localObject = GroupIconHelper.a(paramString);; localObject = paramString)
    {
      if ((paramInt1 == 4) && (!azlj.a(paramString))) {
        paramInt1 = 113;
      }
      for (;;)
      {
        if (paramInt1 == 113) {
          paramByte = 3;
        }
        paramByte = azwz.a(paramByte);
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1, (String)localObject, paramByte, paramInt2, 100, true);
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a((String)localObject);
        if ((localObject != null) && (paramInt1 == 1001))
        {
          ajhf localajhf = (ajhf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(6);
          if ((localajhf != null) && (localajhf.a() != null)) {
            localajhf.a().f(paramString);
          }
          if (this.jdField_a_of_type_Azwm == null)
          {
            this.jdField_a_of_type_Azwm = new azwm(this, null);
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Azwm);
          }
        }
        return localObject;
      }
    }
  }
  
  public void a(int paramInt1, String paramString, int paramInt2, long paramLong)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramLong <= 0L) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {}
    do
    {
      do
      {
        return;
      } while ((paramInt1 == 32) && (paramInt2 != 200) && (paramInt2 != 202) && (paramInt2 != 204));
      if (paramInt1 == 32) {}
      for (byte b = 1;; b = 0)
      {
        FaceInfo localFaceInfo = new FaceInfo(paramInt1, paramString, false, b, 3, false, paramInt2);
        String str = FaceInfo.a(paramInt1, paramString, paramInt2);
        if (this.jdField_b_of_type_JavaUtilHashtable.get(str) == null) {
          this.jdField_b_of_type_JavaUtilHashtable.put(str, localFaceInfo);
        }
        if (this.jdField_a_of_type_Azwn == null)
        {
          this.jdField_a_of_type_Azwn = new azwn(this, null);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Azwn);
        }
        if (paramInt1 != 32) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramString, paramInt2, paramLong);
        return;
      }
    } while (paramInt1 != 16);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(paramString, paramInt2, paramLong);
  }
  
  public void a(AppInterface paramAppInterface)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != paramAppInterface)
    {
      d();
      if ((paramAppInterface instanceof QQAppInterface)) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)paramAppInterface);
      }
    }
  }
  
  public void a(AppInterface paramAppInterface, FaceInfo paramFaceInfo)
  {
    if ((paramFaceInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqhead.FaceDecoderImpl", 2, "onDecodeTaskCompletedNeedDownload, faceInfo=" + paramFaceInfo.toString());
      }
      this.jdField_b_of_type_Int -= 1;
      paramAppInterface = (FaceInfo)this.jdField_a_of_type_JavaUtilHashtable.get(paramFaceInfo.b());
      if (paramAppInterface != null)
      {
        if (this.jdField_a_of_type_Azwn == null)
        {
          this.jdField_a_of_type_Azwn = new azwn(this, null);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Azwn);
        }
        azwg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramAppInterface);
      }
    } while ((this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_JavaUtilLinkedList.isEmpty()) || (this.jdField_b_of_type_Int >= this.jdField_a_of_type_Int));
    e();
  }
  
  public void a(FaceInfo paramFaceInfo, Bitmap paramBitmap)
  {
    if ((paramFaceInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqhead.FaceDecoderImpl", 2, "onDecodeTaskCompleted, faceInfo=" + paramFaceInfo.toString());
    }
    this.jdField_b_of_type_Int -= 1;
    if ((!this.jdField_a_of_type_JavaUtilLinkedList.isEmpty()) && (!this.jdField_a_of_type_Boolean)) {
      e();
    }
    FaceInfo localFaceInfo = (FaceInfo)this.jdField_a_of_type_JavaUtilHashtable.remove(paramFaceInfo.b());
    int j;
    if (localFaceInfo != null)
    {
      j = FaceInfo.r;
      if (paramBitmap == null) {
        break label161;
      }
    }
    label161:
    for (int i = FaceInfo.f;; i = FaceInfo.g)
    {
      localFaceInfo.a(j, i);
      if ((this.jdField_a_of_type_Azwj == null) || (paramBitmap == null)) {
        break;
      }
      this.jdField_a_of_type_Azwj.onDecodeTaskCompleted(this.jdField_b_of_type_Int + this.jdField_a_of_type_JavaUtilLinkedList.size(), paramFaceInfo.jdField_a_of_type_Int, paramFaceInfo.jdField_a_of_type_JavaLangString, paramBitmap);
      return;
    }
  }
  
  protected void a(boolean paramBoolean, int paramInt1, String paramString, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    label177:
    do
    {
      Object localObject;
      do
      {
        Bitmap localBitmap;
        do
        {
          return;
          localObject = FaceInfo.a(paramInt1, paramString, paramInt2);
          if ((paramInt1 == 101) && ((!paramBoolean) || (this.jdField_a_of_type_Boolean))) {
            break label177;
          }
          localBitmap = a(paramInt1, paramString, paramInt2, (byte)3);
          if (localBitmap == null) {
            break;
          }
          localObject = (FaceInfo)this.jdField_a_of_type_JavaUtilHashtable.remove(localObject);
          if (localObject != null) {
            ((FaceInfo)localObject).a(FaceInfo.r, FaceInfo.f);
          }
        } while (this.jdField_a_of_type_Azwj == null);
        this.jdField_a_of_type_Azwj.onDecodeTaskCompleted(this.jdField_b_of_type_Int + this.jdField_a_of_type_JavaUtilLinkedList.size(), paramInt1, paramString, localBitmap);
        return;
        paramString = (FaceInfo)this.jdField_a_of_type_JavaUtilHashtable.get(localObject);
        if (paramString != null)
        {
          a(paramString);
          return;
        }
        paramString = (FaceInfo)this.jdField_b_of_type_JavaUtilHashtable.remove(localObject);
      } while (paramString == null);
      paramString.a(FaceInfo.j);
      this.jdField_a_of_type_JavaUtilHashtable.put(localObject, paramString);
      a(paramString);
      return;
      paramString = (FaceInfo)this.jdField_a_of_type_JavaUtilHashtable.remove(localObject);
    } while (paramString == null);
    paramInt2 = FaceInfo.r;
    if (!paramBoolean) {}
    for (paramInt1 = FaceInfo.g;; paramInt1 = FaceInfo.h)
    {
      paramString.a(paramInt2, paramInt1);
      return;
    }
  }
  
  public boolean a(String paramString, int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, byte paramByte, int paramInt3, int paramInt4, boolean paramBoolean3)
  {
    if ((paramString == null) || (paramString.length() < 5))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqhead.FaceDecoderImpl", 2, "requestDecodeFace fail. type=" + paramInt2 + ", uin=" + paramString);
      }
      return false;
    }
    byte b = 3;
    if (paramInt3 == 0) {
      if ((paramInt2 != 101) && (paramInt2 != 1001)) {}
    }
    String str;
    for (b = 3;; b = (byte)paramInt3)
    {
      paramInt3 = azwz.a(b);
      str = FaceInfo.a(paramInt2, paramString, paramInt1);
      FaceInfo localFaceInfo = (FaceInfo)this.jdField_a_of_type_JavaUtilHashtable.get(str);
      if ((localFaceInfo == null) || (localFaceInfo.a(FaceInfo.j, 300000L))) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqhead.FaceDecoderImpl", 2, "requestDecodeFace, uin repeat. uin=" + paramString);
      }
      if ((localFaceInfo.b) && (!paramBoolean2)) {
        localFaceInfo.b = false;
      }
      localFaceInfo.c = paramInt3;
      return true;
    }
    paramString = new FaceInfo(paramInt2, paramString, paramBoolean2, paramByte, paramInt3, false, paramInt1, paramBoolean3, 100);
    paramString.a(FaceInfo.j);
    this.jdField_a_of_type_JavaUtilHashtable.put(str, paramString);
    a(paramString);
    return true;
  }
  
  public void d()
  {
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    azwm localazwm = this.jdField_a_of_type_Azwm;
    azwn localazwn = this.jdField_a_of_type_Azwn;
    azwo localazwo = this.jdField_a_of_type_Azwo;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_Azwm = null;
    this.jdField_a_of_type_Azwo = null;
    this.jdField_a_of_type_Azwn = null;
    if (localQQAppInterface != null)
    {
      if (localazwm != null) {
        localQQAppInterface.removeObserver(localazwm);
      }
      if (localazwn != null) {
        localQQAppInterface.removeObserver(localazwn);
      }
      if (localazwo != null) {
        localQQAppInterface.removeObserver(localazwo);
      }
    }
    super.d();
  }
  
  protected void e()
  {
    Object localObject1 = null;
    if (this.jdField_a_of_type_JavaUtilLinkedList.isEmpty()) {
      QLog.i("Q.qqhead.FaceDecoderImpl", 2, " runNextTask, mReadyRequests is empty");
    }
    label204:
    do
    {
      return;
      try
      {
        localObject2 = (FaceInfo)this.jdField_a_of_type_JavaUtilLinkedList.removeFirst();
        try
        {
          if (QLog.isColorLevel()) {
            QLog.i("Q.qqhead.FaceDecoderImpl", 2, " runNextTask, faceinfo=" + ((FaceInfo)localObject2).toString());
          }
          if (((((FaceInfo)localObject2).jdField_a_of_type_Int == 101) || (((FaceInfo)localObject2).jdField_a_of_type_Int == 1001)) && (this.jdField_a_of_type_Azwm == null))
          {
            this.jdField_a_of_type_Azwm = new azwm(this, null);
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Azwm);
          }
          if (((((FaceInfo)localObject2).jdField_a_of_type_Int == 4) || (((FaceInfo)localObject2).jdField_a_of_type_Int == 113)) && (!azlj.a(((FaceInfo)localObject2).jdField_a_of_type_JavaLangString)))
          {
            if (this.jdField_a_of_type_Azwo == null) {
              this.jdField_a_of_type_Azwo = new azwo(this, null);
            }
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Azwo);
          }
          this.jdField_b_of_type_Int += 1;
          FaceDecodeTask.a(FaceDecodeTask.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (FaceInfo)localObject2, this));
          return;
        }
        catch (Throwable localThrowable2)
        {
          localObject1 = localObject2;
          localObject2 = localThrowable2;
        }
      }
      catch (Throwable localThrowable1)
      {
        Object localObject2;
        break label204;
      }
      if (localObject1 != null) {
        this.jdField_b_of_type_Int -= 1;
      }
    } while (!QLog.isColorLevel());
    asfl.a("Q.qqhead.FaceDecoderImpl", new Object[] { "runNextTask", localObject2, localObject1 });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     azwk
 * JD-Core Version:    0.7.0.1
 */