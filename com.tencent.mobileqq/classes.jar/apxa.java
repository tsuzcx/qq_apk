import com.tencent.ark.ArkDispatchTask;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.ark.ArkAiDictUpdateMgr.1;
import com.tencent.mobileqq.ark.ArkAiDictUpdateMgr.1.1.1;
import com.tencent.mobileqq.ark.ArkAppCenter;
import java.lang.ref.WeakReference;

public class apxa
  implements apxl
{
  public apxa(ArkAiDictUpdateMgr.1 param1, aqzr paramaqzr, apxn paramapxn, aqzf paramaqzf) {}
  
  public void a(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      ArkAppCenter.c("ArkApp.Dict.Update", String.format("updateWordDict, one task failed, dict-id=%s", new Object[] { apwz.a(this.jdField_a_of_type_Aqzr) }));
      this.jdField_a_of_type_Apxn.jdField_a_of_type_Boolean = false;
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_Apxn)
      {
        apxn localapxn2 = this.jdField_a_of_type_Apxn;
        int i = localapxn2.jdField_a_of_type_Int - 1;
        localapxn2.jdField_a_of_type_Int = i;
        if (i != 0) {
          return;
        }
        if (this.jdField_a_of_type_Apxn.jdField_a_of_type_Boolean)
        {
          ArkAppCenter.c("ArkApp.Dict.Update", "updateWordDict, all success");
          apwz.a(this.jdField_a_of_type_Aqzf);
          apwz.b(this.jdField_a_of_type_Aqzf);
          apww.b((AppInterface)apwz.a(this.jdField_a_of_type_ComTencentMobileqqArkArkAiDictUpdateMgr$1.this$0).get());
          try
          {
            apwz.b(this.jdField_a_of_type_ComTencentMobileqqArkArkAiDictUpdateMgr$1.this$0, false);
            if (apwz.b(this.jdField_a_of_type_ComTencentMobileqqArkArkAiDictUpdateMgr$1.this$0))
            {
              apwz.a(this.jdField_a_of_type_ComTencentMobileqqArkArkAiDictUpdateMgr$1.this$0, false);
              ArkAppCenter.c("ArkApp.Dict.Update", "updateWordDict, pending update task exists, wait 5 second and update");
              ArkAppCenter.a().postToMainThreadDelayed(new ArkAiDictUpdateMgr.1.1.1(this), 5000L);
            }
            return;
          }
          finally {}
        }
      }
      ArkAppCenter.c("ArkApp.Dict.Update", "updateWordDict, one or more tasks failed.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apxa
 * JD-Core Version:    0.7.0.1
 */