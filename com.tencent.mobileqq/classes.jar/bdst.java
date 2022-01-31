import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.vas.FriendCloneSettingFragment;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class bdst
  extends amcd
{
  public bdst(FriendCloneSettingFragment paramFriendCloneSettingFragment) {}
  
  public void d(boolean paramBoolean, Object paramObject)
  {
    int i;
    if ((paramBoolean) && ((paramObject instanceof ArrayList)))
    {
      paramObject = (ArrayList)paramObject;
      i = ((Integer)paramObject.get(1)).intValue();
      if (i == 257) {
        if (((Boolean)paramObject.get(2)).booleanValue())
        {
          this.a.a(1);
          this.a.jdField_a_of_type_Int = 1;
        }
      }
    }
    for (;;)
    {
      this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      if (this.a.jdField_a_of_type_Beub != null) {
        this.a.jdField_a_of_type_Beub.b();
      }
      return;
      this.a.a(0);
      this.a.jdField_a_of_type_Int = 0;
      continue;
      if (i == 258)
      {
        this.a.jdField_a_of_type_Int = this.a.b;
        continue;
        this.a.a(this.a.jdField_a_of_type_Int);
        if (this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) {
          QQToast.a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 1, alud.a(2131705258), 0).a();
        }
        QLog.e("IphoneTitleBarFragment", 0, "onFriendCloneAuth: failed. ");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdst
 * JD-Core Version:    0.7.0.1
 */