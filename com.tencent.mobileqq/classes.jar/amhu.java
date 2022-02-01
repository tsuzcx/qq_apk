import android.content.Context;
import android.content.res.Resources;
import android.os.Message;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

public class amhu
  extends MqqHandler
{
  public amhu(ShortVideoPlayActivity paramShortVideoPlayActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
          QQToast.a(this.a, 2131718205, 0).a();
          return;
          String str = this.a.getString(2131718206);
          paramMessage = (String)paramMessage.obj;
          QQToast.a(this.a.jdField_a_of_type_AndroidContentContext, 2, str + paramMessage, 0).a();
          bhmq.a(this.a, paramMessage);
          return;
          paramMessage = bhlq.a(this.a.jdField_a_of_type_AndroidContentContext, 232, this.a.jdField_a_of_type_AndroidContentContext.getResources().getString(2131718237), this.a.jdField_a_of_type_AndroidContentContext.getResources().getString(2131718236), 2131718220, 2131717445, new amhv(this), new amhw(this));
          ShortVideoPlayActivity.a(this.a, paramMessage);
          return;
          if (QLog.isColorLevel()) {
            QLog.d("ShortVideoPlayActivity", 2, "...mobile/none => wifi...");
          }
        } while ((this.a.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.a.jdField_a_of_type_JavaLangRefWeakReference.get() == null));
        ((TVK_IMediaPlayer)this.a.jdField_a_of_type_JavaLangRefWeakReference.get()).setDownloadNetworkChange(1);
        return;
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoPlayActivity", 2, "...wifi/none => mobile...");
        }
        if ((this.a.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.a.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
          ((TVK_IMediaPlayer)this.a.jdField_a_of_type_JavaLangRefWeakReference.get()).setDownloadNetworkChange(2);
        }
        if ((this.a.b != 1) && (this.a.b != 2)) {
          break;
        }
      } while (!this.a.b());
      this.a.j();
      this.a.r();
      return;
    } while ((this.a.b != 0) && (this.a.b != 5));
    ShortVideoPlayActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amhu
 * JD-Core Version:    0.7.0.1
 */