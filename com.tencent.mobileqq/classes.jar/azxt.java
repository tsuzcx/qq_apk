import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.mobileqq.activity.aio.audiopanel.CommonRecordSoundPanel;
import com.tencent.mobileqq.troop.homework.entry.ui.PublishHomeWorkFragment;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Calendar;

public class azxt
  extends Handler
{
  WeakReference<PublishHomeWorkFragment> a;
  
  public azxt(PublishHomeWorkFragment paramPublishHomeWorkFragment, Looper paramLooper)
  {
    super(paramLooper);
    this.a = new WeakReference(paramPublishHomeWorkFragment);
  }
  
  void a()
  {
    PublishHomeWorkFragment localPublishHomeWorkFragment = (PublishHomeWorkFragment)this.a.get();
    if ((localPublishHomeWorkFragment == null) || ((!localPublishHomeWorkFragment.isAdded()) && (localPublishHomeWorkFragment.jdField_a_of_type_AndroidWidgetEditText == null))) {}
    do
    {
      return;
      if (localPublishHomeWorkFragment.jdField_a_of_type_JavaLangString == null) {
        localPublishHomeWorkFragment.jdField_a_of_type_JavaLangString = "";
      }
    } while (localPublishHomeWorkFragment.jdField_a_of_type_Int != 1);
    Object localObject = Calendar.getInstance();
    int i = ((Calendar)localObject).get(2) + 1;
    int j = ((Calendar)localObject).get(5);
    localObject = localPublishHomeWorkFragment.getString(2131697699, new Object[] { Integer.valueOf(i), Integer.valueOf(j), localPublishHomeWorkFragment.jdField_a_of_type_JavaLangString }).trim();
    String str1 = localPublishHomeWorkFragment.getString(2131697699, new Object[] { Integer.valueOf(i), Integer.valueOf(j), "" }).trim();
    String str2 = localPublishHomeWorkFragment.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    if ((TextUtils.isEmpty(str2)) || (str1.equals(str2))) {
      localPublishHomeWorkFragment.jdField_a_of_type_AndroidWidgetEditText.setText((CharSequence)localObject);
    }
    localPublishHomeWorkFragment.g();
    localPublishHomeWorkFragment.f();
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    if (QLog.isColorLevel()) {
      QLog.d("PublishHomeWorkFragment", 2, "handle msg " + paramMessage.what);
    }
    PublishHomeWorkFragment localPublishHomeWorkFragment = (PublishHomeWorkFragment)this.a.get();
    if ((localPublishHomeWorkFragment == null) || (!localPublishHomeWorkFragment.isAdded())) {
      if (QLog.isColorLevel()) {
        QLog.d("PublishHomeWorkFragment", 2, "reference null");
      }
    }
    do
    {
      return;
      switch (paramMessage.what)
      {
      default: 
        return;
      case 3: 
        localPublishHomeWorkFragment.f = true;
        localPublishHomeWorkFragment.jdField_a_of_type_Bfpc.c(false);
        return;
      case 515: 
        QLog.d("PublishHomeWorkFragment", 1, "init data time out");
        localPublishHomeWorkFragment.j = true;
        a();
        return;
      case 513: 
        a();
        return;
      case 514: 
        localPublishHomeWorkFragment.f();
        return;
      case 101: 
        localPublishHomeWorkFragment.f = false;
        localPublishHomeWorkFragment.l();
        return;
      case 102: 
        int i = (int)localPublishHomeWorkFragment.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.a();
        if (i < 1000)
        {
          bcql.a(localPublishHomeWorkFragment.getActivity(), ajya.a(2131708844), 0).a();
          localPublishHomeWorkFragment.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.b();
          return;
        }
        if (!bbfj.d(localPublishHomeWorkFragment.getActivity()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("PublishHomeWorkFragment", 2, "no network toast");
          }
          bcql.a(localPublishHomeWorkFragment.getActivity(), 2131697484, 0).a();
          localPublishHomeWorkFragment.f = false;
          localPublishHomeWorkFragment.l();
          return;
        }
        paramMessage = paramMessage.obj.toString();
        File localFile = new File(paramMessage);
        if (localFile.exists()) {}
        for (long l = localFile.length();; l = 0L)
        {
          paramMessage = new babf(paramMessage, null, i / 1000, (int)l, localPublishHomeWorkFragment.b);
          localPublishHomeWorkFragment.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(paramMessage);
          localPublishHomeWorkFragment.f = false;
          localPublishHomeWorkFragment.l();
          return;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("PublishHomeWorkFragment", 2, "parse config from network success");
      }
    } while ((localPublishHomeWorkFragment.j) || (paramMessage.obj == null) || (!(paramMessage.obj instanceof String)));
    localPublishHomeWorkFragment.a((String)paramMessage.obj, paramMessage.arg1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azxt
 * JD-Core Version:    0.7.0.1
 */