import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.GroupIconHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.util.FaceDecodeTask;
import com.tencent.mobileqq.util.FaceInfo;

public class bdbm
  extends bdbk
{
  bdbp jdField_a_of_type_Bdbp;
  bdbq jdField_a_of_type_Bdbq;
  bdbr jdField_a_of_type_Bdbr;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public bdbm(AppInterface paramAppInterface, int paramInt1, int paramInt2, String paramString, byte paramByte, int paramInt3, int paramInt4, boolean paramBoolean1, Drawable paramDrawable1, Drawable paramDrawable2, bdbl parambdbl, boolean paramBoolean2)
  {
    super(paramAppInterface, paramInt1, paramInt2, paramString, paramByte, paramInt3, paramInt4, paramBoolean1, paramDrawable1, paramDrawable2, parambdbl, paramBoolean2);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)paramAppInterface);
  }
  
  private Bitmap b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo == null) {
      return null;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_JavaLangString;
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_Int == 1001) {
      localObject = GroupIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_JavaLangString);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_Int, (String)localObject, (byte)this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.c, this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_b_of_type_Int, 100, paramBoolean);
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a((String)localObject);
    if ((localObject != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_Int == 1001))
    {
      alri localalri = (alri)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(6);
      if ((localalri != null) && (localalri.a() != null)) {
        localalri.a().f(this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_JavaLangString);
      }
    }
    return localObject;
  }
  
  protected Bitmap a(boolean paramBoolean)
  {
    return b(paramBoolean);
  }
  
  public void a()
  {
    if ((!this.b) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      bdbu localbdbu;
      if (this.jdField_a_of_type_Bdbq != null)
      {
        localbdbu = (bdbu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(170);
        if (localbdbu != null) {
          localbdbu.b(this.jdField_a_of_type_Bdbq);
        }
      }
      if (this.jdField_a_of_type_Bdbp != null)
      {
        localbdbu = (bdbu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(170);
        if (localbdbu != null) {
          localbdbu.b(this.jdField_a_of_type_Bdbp);
        }
      }
      if (this.jdField_a_of_type_Bdbr != null)
      {
        localbdbu = (bdbu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(170);
        if (localbdbu != null) {
          localbdbu.b(this.jdField_a_of_type_Bdbr);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    }
    super.a();
  }
  
  protected void a(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)paramAppInterface);
  }
  
  public void a(boolean paramBoolean, int paramInt, String paramString, Object paramObject)
  {
    if ((this.b) || (this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo == null)) {}
    while ((paramInt != this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_Int) || (!this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_JavaLangString.equals(paramString))) {
      return;
    }
    if (paramObject != null)
    {
      paramString = (bdbu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(170);
      if (paramString != null) {
        paramString.b(paramObject);
      }
    }
    if (paramBoolean)
    {
      paramString = b();
      if (paramString != null) {
        a(this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo, paramString);
      }
    }
    for (;;)
    {
      System.currentTimeMillis();
      return;
      a();
      continue;
      a(this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo, null);
    }
  }
  
  protected boolean a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo == null) {
      return false;
    }
    bdbu localbdbu;
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_Int == 101) || (this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_Int == 1001))
    {
      this.jdField_a_of_type_Bdbp = new bdbp(this, this);
      localbdbu = (bdbu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(170);
      if (localbdbu != null) {
        localbdbu.a(this.jdField_a_of_type_Bdbp);
      }
    }
    if (((this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_Int == 4) || (this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_Int == 113)) && (!bcpx.a(this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_JavaLangString)))
    {
      this.jdField_a_of_type_Bdbr = new bdbr(this, this);
      localbdbu = (bdbu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(170);
      if (localbdbu != null) {
        localbdbu.a(this.jdField_a_of_type_Bdbr);
      }
    }
    FaceDecodeTask.a(FaceDecodeTask.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo, this));
    return true;
  }
  
  protected Bitmap b()
  {
    return b(false);
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_Bdbq == null) {
      this.jdField_a_of_type_Bdbq = new bdbq(this, this);
    }
    Object localObject = (bdbu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(170);
    if (localObject != null) {
      ((bdbu)localObject).a(this.jdField_a_of_type_Bdbq);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_Int == 11) || (this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_Int == 4) || (this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_Int == 32) || (this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_Int == 16) || (this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_Int == 1001))
    {
      localObject = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1);
      if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_Int != 1) {
        break label170;
      }
      ((FriendListHandler)localObject).a(this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_Byte, this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_b_of_type_Byte);
    }
    for (;;)
    {
      System.currentTimeMillis();
      return;
      label170:
      if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_Int == 11) {
        ((FriendListHandler)localObject).b(this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_b_of_type_Byte);
      } else if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_Int == 4) {
        ((FriendListHandler)localObject).a(this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_b_of_type_Byte);
      } else if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_Int == 32) {
        ((FriendListHandler)localObject).a(this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_Byte, this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_b_of_type_Byte);
      } else if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_Int == 16) {
        ((FriendListHandler)localObject).b(this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_Byte, this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_b_of_type_Byte);
      } else if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_Int == 101) {
        ((alri)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(6)).a(this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_JavaLangString, true);
      } else if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_Int == 1001) {
        ((alri)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(6)).a(GroupIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_JavaLangString), true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdbm
 * JD-Core Version:    0.7.0.1
 */