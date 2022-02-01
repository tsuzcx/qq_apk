import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FavFileInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class atcd
  extends atkf
{
  atcd(atcb paramatcb, Bundle paramBundle) {}
  
  public void a(int paramInt, List<FavFileInfo> paramList, Bundle paramBundle)
  {
    if (!atcb.c(this.jdField_a_of_type_Atcb))
    {
      QLog.d(atcb.a, 1, atcb.b + "<<<syncLastFileRecord is not getting");
      return;
    }
    QLog.i(atcb.a, 1, atcb.b + "<<<syncLastFileRecord result errCode:" + paramInt);
    if (paramBundle == null) {}
    for (Bundle localBundle = new Bundle();; localBundle = paramBundle)
    {
      if (this.jdField_a_of_type_AndroidOsBundle != null) {
        localBundle.putAll(this.jdField_a_of_type_AndroidOsBundle);
      }
      atcb.e(this.jdField_a_of_type_Atcb);
      if (paramInt != 0)
      {
        int i = 2131697918;
        if (paramInt == 65535) {
          i = 2131697919;
        }
        paramInt = BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131299080);
        int j = (int)bhdz.a(BaseApplicationImpl.getContext(), 5.0F);
        QQToast.a(BaseApplicationImpl.getContext(), 0, i, 0).b(paramInt - j);
        atcb.g(this.jdField_a_of_type_Atcb);
        this.jdField_a_of_type_Atcb.notifyObservers(new Object[] { Integer.valueOf(3), { Boolean.valueOf(false), localBundle } });
        return;
      }
      atcb.a(this.jdField_a_of_type_Atcb).getFileManagerEngine().a().a(atcb.a(this.jdField_a_of_type_Atcb));
      atcb.a(this.jdField_a_of_type_Atcb);
      atcb.h(this.jdField_a_of_type_Atcb);
      if (paramBundle != null)
      {
        atcb.a(this.jdField_a_of_type_Atcb, paramBundle.getLong("resultTimestamp"));
        boolean bool = paramBundle.getBoolean("fecth_end");
        atcb.a(this.jdField_a_of_type_Atcb, paramBundle.getBoolean("fecth_local_end"));
        if ((bool) && ((paramList == null) || (paramList.size() == 0))) {
          atcb.b(this.jdField_a_of_type_Atcb, true);
        }
        QLog.i(atcb.a, 1, atcb.b + "syncLastFileRecord result: nextTimestamp:" + atcb.a(this.jdField_a_of_type_Atcb) + " gettedListEnd:" + bool + " localEnd:" + atcb.b(this.jdField_a_of_type_Atcb));
      }
      for (;;)
      {
        paramBundle = new atch(this.jdField_a_of_type_Atcb);
        this.jdField_a_of_type_Atcb.a(paramList, paramBundle);
        this.jdField_a_of_type_Atcb.a(paramBundle);
        atcb.i(this.jdField_a_of_type_Atcb);
        this.jdField_a_of_type_Atcb.notifyObservers(new Object[] { Integer.valueOf(3), { Boolean.valueOf(true), localBundle } });
        return;
        QLog.i(atcb.a, 1, atcb.b + "syncLastFileRecord result: lastTimestamp:" + atcb.a(this.jdField_a_of_type_Atcb) + " exData=null");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atcd
 * JD-Core Version:    0.7.0.1
 */