import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FavFileInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class asvk
  extends atbu
{
  asvk(asvi paramasvi, Bundle paramBundle) {}
  
  public void a(int paramInt, List<FavFileInfo> paramList, Bundle paramBundle)
  {
    if (!asvi.c(this.jdField_a_of_type_Asvi))
    {
      QLog.d(asvi.a, 1, asvi.b + "<<<syncLastFileRecord is not getting");
      return;
    }
    QLog.i(asvi.a, 1, asvi.b + "<<<syncLastFileRecord result errCode:" + paramInt);
    if (paramBundle == null) {}
    for (Bundle localBundle = new Bundle();; localBundle = paramBundle)
    {
      if (this.jdField_a_of_type_AndroidOsBundle != null) {
        localBundle.putAll(this.jdField_a_of_type_AndroidOsBundle);
      }
      asvi.e(this.jdField_a_of_type_Asvi);
      if (paramInt != 0)
      {
        int i = 2131697411;
        if (paramInt == 65535) {
          i = 2131697412;
        }
        paramInt = BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131298998);
        int j = (int)bgme.a(BaseApplicationImpl.getContext(), 5.0F);
        QQToast.a(BaseApplicationImpl.getContext(), 0, i, 0).b(paramInt - j);
        asvi.g(this.jdField_a_of_type_Asvi);
        this.jdField_a_of_type_Asvi.notifyObservers(new Object[] { Integer.valueOf(3), { Boolean.valueOf(false), localBundle } });
        return;
      }
      asvi.a(this.jdField_a_of_type_Asvi).a().a().a(asvi.a(this.jdField_a_of_type_Asvi));
      asvi.a(this.jdField_a_of_type_Asvi);
      asvi.h(this.jdField_a_of_type_Asvi);
      if (paramBundle != null)
      {
        asvi.a(this.jdField_a_of_type_Asvi, paramBundle.getLong("resultTimestamp"));
        boolean bool = paramBundle.getBoolean("fecth_end");
        asvi.a(this.jdField_a_of_type_Asvi, paramBundle.getBoolean("fecth_local_end"));
        if ((bool) && ((paramList == null) || (paramList.size() == 0))) {
          asvi.b(this.jdField_a_of_type_Asvi, true);
        }
        QLog.i(asvi.a, 1, asvi.b + "syncLastFileRecord result: nextTimestamp:" + asvi.a(this.jdField_a_of_type_Asvi) + " gettedListEnd:" + bool + " localEnd:" + asvi.b(this.jdField_a_of_type_Asvi));
      }
      for (;;)
      {
        paramBundle = new asvo(this.jdField_a_of_type_Asvi);
        this.jdField_a_of_type_Asvi.a(paramList, paramBundle);
        this.jdField_a_of_type_Asvi.a(paramBundle);
        asvi.i(this.jdField_a_of_type_Asvi);
        this.jdField_a_of_type_Asvi.notifyObservers(new Object[] { Integer.valueOf(3), { Boolean.valueOf(true), localBundle } });
        return;
        QLog.i(asvi.a, 1, asvi.b + "syncLastFileRecord result: lastTimestamp:" + asvi.a(this.jdField_a_of_type_Asvi) + " exData=null");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asvk
 * JD-Core Version:    0.7.0.1
 */