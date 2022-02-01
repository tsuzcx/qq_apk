import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDecodeTask;
import com.tencent.mobileqq.app.face.FaceInfo;
import com.tencent.mobileqq.app.face.GroupIconHelper;
import java.lang.ref.WeakReference;

public class aocj
  extends aoch
{
  aocm jdField_a_of_type_Aocm;
  aocn jdField_a_of_type_Aocn;
  aoco jdField_a_of_type_Aoco;
  WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  
  public aocj(AppInterface paramAppInterface, int paramInt1, int paramInt2, String paramString, byte paramByte, int paramInt3, int paramInt4, boolean paramBoolean1, Drawable paramDrawable1, Drawable paramDrawable2, aoci paramaoci, boolean paramBoolean2)
  {
    super(paramAppInterface, paramInt1, paramInt2, paramString, paramByte, paramInt3, paramInt4, paramBoolean1, paramDrawable1, paramDrawable2, paramaoci, paramBoolean2);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference((QQAppInterface)paramAppInterface);
  }
  
  private Bitmap b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo == null) {
      return null;
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_JavaLangString;
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_Int == 1001) {
      localObject1 = GroupIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_JavaLangString);
    }
    Object localObject2 = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject2 == null) {
      return null;
    }
    localObject1 = ((QQAppInterface)localObject2).a(((QQAppInterface)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_Int, (String)localObject1, (byte)this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.c, this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_b_of_type_Int, 100, paramBoolean));
    if ((localObject1 != null) && (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_Int == 1001))
    {
      localObject2 = (anks)((QQAppInterface)localObject2).a(6);
      if ((localObject2 != null) && (((anks)localObject2).a() != null)) {
        ((anks)localObject2).a().f(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_JavaLangString);
      }
    }
    return localObject1;
  }
  
  protected Bitmap a()
  {
    return b(false);
  }
  
  protected Bitmap a(boolean paramBoolean)
  {
    return b(paramBoolean);
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_Aocn == null) {
      this.jdField_a_of_type_Aocn = new aocn(this, this);
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localQQAppInterface == null) {
      return;
    }
    Object localObject = (aocs)localQQAppInterface.getManager(170);
    if (localObject != null) {
      ((aocs)localObject).a(this.jdField_a_of_type_Aocn);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_Int == 11) || (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_Int == 4) || (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_Int == 32) || (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_Int == 16) || (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_Int == 1001))
    {
      localObject = (FriendListHandler)localQQAppInterface.a(1);
      if (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_Int != 1) {
        break label180;
      }
      ((FriendListHandler)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_Byte, this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_b_of_type_Byte);
    }
    for (;;)
    {
      System.currentTimeMillis();
      return;
      label180:
      if (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_Int == 11) {
        ((FriendListHandler)localObject).b(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_b_of_type_Byte);
      } else if (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_Int == 4) {
        ((FriendListHandler)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_b_of_type_Byte);
      } else if (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_Int == 32) {
        ((FriendListHandler)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_Byte, this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_b_of_type_Byte);
      } else if (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_Int == 16) {
        ((FriendListHandler)localObject).b(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_Byte, this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_b_of_type_Byte);
      } else if (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_Int == 101) {
        ((anks)localQQAppInterface.a(6)).a(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_JavaLangString, true);
      } else if (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_Int == 1001) {
        ((anks)localQQAppInterface.a(6)).a(GroupIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_JavaLangString), true);
      }
    }
  }
  
  protected void a(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference((QQAppInterface)paramAppInterface);
  }
  
  public void a(boolean paramBoolean, int paramInt, String paramString, Object paramObject)
  {
    if ((this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo == null)) {}
    do
    {
      do
      {
        return;
      } while ((paramInt != this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_Int) || (!this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_JavaLangString.equals(paramString)));
      if (paramObject == null) {
        break;
      }
      paramString = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (paramString == null);
    paramString = (aocs)paramString.getManager(170);
    if (paramString != null) {
      paramString.b(paramObject);
    }
    if (paramBoolean)
    {
      paramString = a();
      if (paramString != null) {
        a(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo, paramString);
      }
    }
    for (;;)
    {
      System.currentTimeMillis();
      return;
      a();
      continue;
      a(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo, null);
    }
  }
  
  protected boolean a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo == null) {
      return false;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localQQAppInterface == null) {
      return false;
    }
    aocs localaocs;
    if ((this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_Int == 101) || (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_Int == 1001))
    {
      this.jdField_a_of_type_Aocm = new aocm(this, this);
      localaocs = (aocs)localQQAppInterface.getManager(170);
      if (localaocs != null) {
        localaocs.a(this.jdField_a_of_type_Aocm);
      }
    }
    if (((this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_Int == 4) || (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_Int == 113)) && (!bfup.a(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_JavaLangString)))
    {
      this.jdField_a_of_type_Aoco = new aoco(this, this);
      localaocs = (aocs)localQQAppInterface.getManager(170);
      if (localaocs != null) {
        localaocs.a(this.jdField_a_of_type_Aoco);
      }
    }
    FaceDecodeTask.a(FaceDecodeTask.a(localQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo, this));
    return true;
  }
  
  public void b()
  {
    Object localObject = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((!this.jdField_a_of_type_Boolean) && (localObject != null))
    {
      aocs localaocs;
      if (this.jdField_a_of_type_Aocn != null)
      {
        localaocs = (aocs)((QQAppInterface)localObject).getManager(170);
        if (localaocs != null) {
          localaocs.b(this.jdField_a_of_type_Aocn);
        }
      }
      if (this.jdField_a_of_type_Aocm != null)
      {
        localaocs = (aocs)((QQAppInterface)localObject).getManager(170);
        if (localaocs != null) {
          localaocs.b(this.jdField_a_of_type_Aocm);
        }
      }
      if (this.jdField_a_of_type_Aoco != null)
      {
        localObject = (aocs)((QQAppInterface)localObject).getManager(170);
        if (localObject != null) {
          ((aocs)localObject).b(this.jdField_a_of_type_Aoco);
        }
      }
      this.jdField_a_of_type_JavaLangRefWeakReference = null;
    }
    super.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aocj
 * JD-Core Version:    0.7.0.1
 */