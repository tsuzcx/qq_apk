import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FavFileInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class atlo
  extends attp
{
  atlo(atlm paramatlm, Bundle paramBundle) {}
  
  public void a(int paramInt, List<FavFileInfo> paramList, Bundle paramBundle)
  {
    if (!atlm.c(this.jdField_a_of_type_Atlm))
    {
      QLog.d(atlm.a, 1, atlm.b + "<<<syncLastFileRecord is not getting");
      return;
    }
    QLog.i(atlm.a, 1, atlm.b + "<<<syncLastFileRecord result errCode:" + paramInt);
    if (paramBundle == null) {}
    for (Bundle localBundle = new Bundle();; localBundle = paramBundle)
    {
      if (this.jdField_a_of_type_AndroidOsBundle != null) {
        localBundle.putAll(this.jdField_a_of_type_AndroidOsBundle);
      }
      atlm.e(this.jdField_a_of_type_Atlm);
      if (paramInt != 0)
      {
        int i = 2131697492;
        if (paramInt == 65535) {
          i = 2131697493;
        }
        paramInt = BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131299011);
        int j = (int)bhmg.a(BaseApplicationImpl.getContext(), 5.0F);
        QQToast.a(BaseApplicationImpl.getContext(), 0, i, 0).b(paramInt - j);
        atlm.g(this.jdField_a_of_type_Atlm);
        this.jdField_a_of_type_Atlm.notifyObservers(new Object[] { Integer.valueOf(3), { Boolean.valueOf(false), localBundle } });
        return;
      }
      atlm.a(this.jdField_a_of_type_Atlm).a().a().a(atlm.a(this.jdField_a_of_type_Atlm));
      atlm.a(this.jdField_a_of_type_Atlm);
      atlm.h(this.jdField_a_of_type_Atlm);
      if (paramBundle != null)
      {
        atlm.a(this.jdField_a_of_type_Atlm, paramBundle.getLong("resultTimestamp"));
        boolean bool = paramBundle.getBoolean("fecth_end");
        atlm.a(this.jdField_a_of_type_Atlm, paramBundle.getBoolean("fecth_local_end"));
        if ((bool) && ((paramList == null) || (paramList.size() == 0))) {
          atlm.b(this.jdField_a_of_type_Atlm, true);
        }
        QLog.i(atlm.a, 1, atlm.b + "syncLastFileRecord result: nextTimestamp:" + atlm.a(this.jdField_a_of_type_Atlm) + " gettedListEnd:" + bool + " localEnd:" + atlm.b(this.jdField_a_of_type_Atlm));
      }
      for (;;)
      {
        paramBundle = new atls(this.jdField_a_of_type_Atlm);
        this.jdField_a_of_type_Atlm.a(paramList, paramBundle);
        this.jdField_a_of_type_Atlm.a(paramBundle);
        atlm.i(this.jdField_a_of_type_Atlm);
        this.jdField_a_of_type_Atlm.notifyObservers(new Object[] { Integer.valueOf(3), { Boolean.valueOf(true), localBundle } });
        return;
        QLog.i(atlm.a, 1, atlm.b + "syncLastFileRecord result: lastTimestamp:" + atlm.a(this.jdField_a_of_type_Atlm) + " exData=null");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atlo
 * JD-Core Version:    0.7.0.1
 */