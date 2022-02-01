import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FavFileInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class arxx
  extends asfz
{
  arxx(arxv paramarxv, Bundle paramBundle) {}
  
  public void a(int paramInt, List<FavFileInfo> paramList, Bundle paramBundle)
  {
    if (!arxv.c(this.jdField_a_of_type_Arxv))
    {
      QLog.d(arxv.a, 1, arxv.b + "<<<syncLastFileRecord is not getting");
      return;
    }
    QLog.i(arxv.a, 1, arxv.b + "<<<syncLastFileRecord result errCode:" + paramInt);
    if (paramBundle == null) {}
    for (Bundle localBundle = new Bundle();; localBundle = paramBundle)
    {
      if (this.jdField_a_of_type_AndroidOsBundle != null) {
        localBundle.putAll(this.jdField_a_of_type_AndroidOsBundle);
      }
      arxv.e(this.jdField_a_of_type_Arxv);
      if (paramInt != 0)
      {
        int i = 2131697638;
        if (paramInt == 65535) {
          i = 2131697639;
        }
        paramInt = BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131299076);
        int j = (int)bfvh.a(BaseApplicationImpl.getContext(), 5.0F);
        QQToast.a(BaseApplicationImpl.getContext(), 0, i, 0).b(paramInt - j);
        arxv.g(this.jdField_a_of_type_Arxv);
        this.jdField_a_of_type_Arxv.notifyObservers(new Object[] { Integer.valueOf(3), { Boolean.valueOf(false), localBundle } });
        return;
      }
      arxv.a(this.jdField_a_of_type_Arxv).getFileManagerEngine().a().a(arxv.a(this.jdField_a_of_type_Arxv));
      arxv.a(this.jdField_a_of_type_Arxv);
      arxv.h(this.jdField_a_of_type_Arxv);
      if (paramBundle != null)
      {
        arxv.a(this.jdField_a_of_type_Arxv, paramBundle.getLong("resultTimestamp"));
        boolean bool = paramBundle.getBoolean("fecth_end");
        arxv.a(this.jdField_a_of_type_Arxv, paramBundle.getBoolean("fecth_local_end"));
        if ((bool) && ((paramList == null) || (paramList.size() == 0))) {
          arxv.b(this.jdField_a_of_type_Arxv, true);
        }
        QLog.i(arxv.a, 1, arxv.b + "syncLastFileRecord result: nextTimestamp:" + arxv.a(this.jdField_a_of_type_Arxv) + " gettedListEnd:" + bool + " localEnd:" + arxv.b(this.jdField_a_of_type_Arxv));
      }
      for (;;)
      {
        paramBundle = new aryb(this.jdField_a_of_type_Arxv);
        this.jdField_a_of_type_Arxv.a(paramList, paramBundle);
        this.jdField_a_of_type_Arxv.a(paramBundle);
        arxv.i(this.jdField_a_of_type_Arxv);
        this.jdField_a_of_type_Arxv.notifyObservers(new Object[] { Integer.valueOf(3), { Boolean.valueOf(true), localBundle } });
        return;
        QLog.i(arxv.a, 1, arxv.b + "syncLastFileRecord result: lastTimestamp:" + arxv.a(this.jdField_a_of_type_Arxv) + " exData=null");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arxx
 * JD-Core Version:    0.7.0.1
 */