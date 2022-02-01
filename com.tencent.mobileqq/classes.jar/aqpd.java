import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import android.content.Context;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.beans.SubscribeColorNoteReserveBean;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.qphone.base.util.QLog;

public class aqpd
  implements aqov
{
  public void launch(Context paramContext, ColorNote paramColorNote)
  {
    try
    {
      paramColorNote = paramColorNote.getReserve();
      if (paramColorNote == null) {
        return;
      }
      paramColorNote = (SubscribeColorNoteReserveBean)zzc.a(paramColorNote);
      if (paramColorNote != null)
      {
        CertifiedAccountMeta.StFeed localStFeed = new CertifiedAccountMeta.StFeed();
        localStFeed.mergeFrom(paramColorNote.feedData);
        QLog.d("SubscribeColorNoteLauncher", 2, "articleInfo From ColorNote :\n" + localStFeed.toString());
        zqm.a(paramContext, "", localStFeed, new ExtraTypeInfo(paramColorNote.pageType, 9003), null);
        return;
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqpd
 * JD-Core Version:    0.7.0.1
 */