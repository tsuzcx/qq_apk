import com.tencent.ark.ArkDispatchTask;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.ark.ArkAiDictUpdateMgr.1;
import com.tencent.mobileqq.ark.ArkAiDictUpdateMgr.1.1.1;
import com.tencent.mobileqq.ark.ArkAppCenter;
import java.lang.ref.WeakReference;

public class aqaj
  implements aqau
{
  public aqaj(ArkAiDictUpdateMgr.1 param1, arcy paramarcy, aqaw paramaqaw, arcm paramarcm) {}
  
  public void a(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      ArkAppCenter.c("ArkApp.Dict.Update", String.format("updateWordDict, one task failed, dict-id=%s", new Object[] { aqai.a(this.jdField_a_of_type_Arcy) }));
      this.jdField_a_of_type_Aqaw.jdField_a_of_type_Boolean = false;
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_Aqaw)
      {
        aqaw localaqaw2 = this.jdField_a_of_type_Aqaw;
        int i = localaqaw2.jdField_a_of_type_Int - 1;
        localaqaw2.jdField_a_of_type_Int = i;
        if (i != 0) {
          return;
        }
        if (this.jdField_a_of_type_Aqaw.jdField_a_of_type_Boolean)
        {
          ArkAppCenter.c("ArkApp.Dict.Update", "updateWordDict, all success");
          aqai.a(this.jdField_a_of_type_Arcm);
          aqai.b(this.jdField_a_of_type_Arcm);
          aqaf.b((AppInterface)aqai.a(this.jdField_a_of_type_ComTencentMobileqqArkArkAiDictUpdateMgr$1.this$0).get());
          try
          {
            aqai.b(this.jdField_a_of_type_ComTencentMobileqqArkArkAiDictUpdateMgr$1.this$0, false);
            if (aqai.b(this.jdField_a_of_type_ComTencentMobileqqArkArkAiDictUpdateMgr$1.this$0))
            {
              aqai.a(this.jdField_a_of_type_ComTencentMobileqqArkArkAiDictUpdateMgr$1.this$0, false);
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
 * Qualified Name:     aqaj
 * JD-Core Version:    0.7.0.1
 */