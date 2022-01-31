import android.app.Activity;
import android.content.Intent;
import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.IEventReceiver;
import dov.com.qq.im.capture.text.DynamicTextConfigManager;
import dov.com.qq.im.capture.text.DynamicTextConfigManager.DynamicTextConfigBean;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;

public class bmgc
  extends bmiv
  implements IEventReceiver
{
  private bmgd a;
  
  public bmgc(@NonNull bmix parambmix)
  {
    super(parambmix);
    this.jdField_a_of_type_Bmgd = new bmgd(this.jdField_a_of_type_Bmix);
  }
  
  public void a()
  {
    bmfg localbmfg = (bmfg)a(bmfg.class);
    if (localbmfg != null) {
      localbmfg.d();
    }
  }
  
  protected boolean a(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return super.a(paramMessage);
      int i;
      DynamicTextConfigManager localDynamicTextConfigManager;
      DynamicTextConfigManager.DynamicTextConfigBean localDynamicTextConfigBean;
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("EditVideoAblumList", 2, "handle message MESSAGE_DOODLE_LAYOUT_LOADED");
        }
        Object localObject = (EditVideoParams)this.jdField_a_of_type_Bmkf.getActivity().getIntent().getParcelableExtra(EditVideoParams.class.getName());
        i = ((EditVideoParams)localObject).a("extra_slide_sticker_id", -1);
        localObject = ((EditVideoParams)localObject).a("extra_slide_sticker_str");
        if ((TextUtils.isEmpty((CharSequence)localObject)) || (i == -1)) {
          continue;
        }
        localDynamicTextConfigManager = (DynamicTextConfigManager)blmf.a(7);
        if (!localDynamicTextConfigManager.a()) {
          localDynamicTextConfigManager.c();
        }
        localDynamicTextConfigBean = localDynamicTextConfigManager.a(i + "");
        if (localDynamicTextConfigBean == null) {
          continue;
        }
        if (!localDynamicTextConfigManager.a(localDynamicTextConfigBean)) {
          break label226;
        }
        if (QLog.isColorLevel()) {
          QLog.d("EditVideoAblumList", 2, "isDynamicTextUsable, addSticker : " + localDynamicTextConfigBean.text_id);
        }
        this.jdField_a_of_type_Bmix.a(i, (String)localObject);
      }
      catch (Exception localException) {}
      if (QLog.isColorLevel())
      {
        QLog.d("EditVideoAblumList", 2, bhop.a(localException));
        continue;
        label226:
        if (QLog.isColorLevel()) {
          QLog.d("EditVideoAblumList", 2, "configBean has not downloaded, start download : " + localDynamicTextConfigBean.text_id);
        }
        this.jdField_a_of_type_Bmgd.a(i);
        this.jdField_a_of_type_Bmgd.a(localException);
        localDynamicTextConfigManager.a(localDynamicTextConfigBean, this.jdField_a_of_type_Bmgd);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmgc
 * JD-Core Version:    0.7.0.1
 */