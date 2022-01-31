import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

final class apvm
  implements apac
{
  apvm(QQAppInterface paramQQAppInterface, Context paramContext, FileManagerEntity paramFileManagerEntity, int paramInt1, SessionInfo paramSessionInfo, ChatMessage paramChatMessage, boolean paramBoolean1, boolean paramBoolean2, int paramInt2, Rect paramRect) {}
  
  public void a() {}
  
  public void b()
  {
    Object localObject = new apoe(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, this.jdField_a_of_type_Int);
    new Bundle();
    ((apoe)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    ((apoe)localObject).a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
    ((apoe)localObject).a(this.jdField_a_of_type_Boolean);
    ((apoe)localObject).b(this.jdField_b_of_type_Boolean);
    localObject = new apog(this.jdField_a_of_type_AndroidContentContext, (apoj)localObject);
    ((apog)localObject).a(this.jdField_b_of_type_Int);
    ((apog)localObject).a(this.jdField_a_of_type_AndroidGraphicsRect);
    ((apog)localObject).a(true);
    ((apog)localObject).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apvm
 * JD-Core Version:    0.7.0.1
 */