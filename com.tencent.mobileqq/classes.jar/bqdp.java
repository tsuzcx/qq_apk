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

public class bqdp
  extends bqgi
  implements IEventReceiver
{
  private bqdq a;
  
  public bqdp(@NonNull bqgk parambqgk)
  {
    super(parambqgk);
    this.jdField_a_of_type_Bqdq = new bqdq(this.jdField_a_of_type_Bqgk);
  }
  
  public void a()
  {
    bqct localbqct = (bqct)a(bqct.class);
    if (localbqct != null) {
      localbqct.d();
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
        Object localObject = (EditVideoParams)this.jdField_a_of_type_Bqhs.getActivity().getIntent().getParcelableExtra(EditVideoParams.class.getName());
        i = ((EditVideoParams)localObject).a("extra_slide_sticker_id", -1);
        localObject = ((EditVideoParams)localObject).a("extra_slide_sticker_str");
        if ((TextUtils.isEmpty((CharSequence)localObject)) || (i == -1)) {
          continue;
        }
        localDynamicTextConfigManager = (DynamicTextConfigManager)bplq.a(7);
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
        this.jdField_a_of_type_Bqgk.a(i, (String)localObject);
      }
      catch (Exception localException) {}
      if (QLog.isColorLevel())
      {
        QLog.d("EditVideoAblumList", 2, blhk.a(localException));
        continue;
        label226:
        if (QLog.isColorLevel()) {
          QLog.d("EditVideoAblumList", 2, "configBean has not downloaded, start download : " + localDynamicTextConfigBean.text_id);
        }
        this.jdField_a_of_type_Bqdq.a(i);
        this.jdField_a_of_type_Bqdq.a(localException);
        localDynamicTextConfigManager.a(localDynamicTextConfigBean, this.jdField_a_of_type_Bqdq);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqdp
 * JD-Core Version:    0.7.0.1
 */