import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.capture.view.MusicProviderView;

class bqdd
  implements View.OnClickListener
{
  bqdd(bqdc parambqdc) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.i("EditRecognitionPart", 2, "mRecognitionBubble onClick: invoked. ");
    }
    MusicItemInfo localMusicItemInfo = ((bpoz)bplq.a().c(8)).a();
    if ((MusicProviderView.a) && (localMusicItemInfo != null) && (localMusicItemInfo.mItemId != bqdc.a(this.a).mItemId) && (localMusicItemInfo.mType == 5)) {
      this.a.c();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bqdc.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqdd
 * JD-Core Version:    0.7.0.1
 */