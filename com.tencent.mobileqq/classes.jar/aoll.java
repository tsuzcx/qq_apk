import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoMusic;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoPartManager;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoPlayerExport;
import dov.com.tencent.biz.qqstory.takevideo.music.BlessVoiceChangeManager;
import dov.com.tencent.biz.qqstory.takevideo.music.EditVideoMusicDialog;
import dov.com.tencent.biz.qqstory.takevideo.music.MusicGridAdapter;
import dov.com.tencent.biz.qqstory.takevideo.music.MusicHorizontalSeekView;
import dov.com.tencent.biz.qqstory.takevideo.music.QQStoryMusicInfo;
import dov.com.tencent.mobileqq.shortvideo.ShortVideoUtils;

public class aoll
  extends Handler
{
  public aoll(EditVideoMusicDialog paramEditVideoMusicDialog) {}
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    case 4: 
    case 5: 
    default: 
    case 1: 
    case 2: 
    case 11: 
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                this.a.b();
                if (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMusicMusicGridAdapter != null)
                {
                  this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMusicMusicGridAdapter.a(this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoMusic.jdField_a_of_type_JavaUtilArrayList);
                  this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMusicMusicGridAdapter.notifyDataSetChanged();
                }
                paramMessage = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoMusic.a();
                this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMusicMusicGridAdapter.a(paramMessage);
              } while (paramMessage == null);
              if (paramMessage.jdField_b_of_type_Int == 0)
              {
                this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
                return;
              }
              if ((paramMessage.jdField_b_of_type_Int == 1) && (!this.a.jdField_a_of_type_Boolean))
              {
                this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(6);
                return;
              }
            } while (TextUtils.isEmpty(paramMessage.h));
            this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
            return;
            this.a.b();
            paramMessage = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoMusic.a();
            if (paramMessage != null) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.e("zivonchen", 2, "MSG_PLAY_MUSIC music is NULL!!!!!");
          return;
          paramMessage.f = ((int)ShortVideoUtils.a(paramMessage.h));
          if (paramMessage.d < 0) {
            paramMessage.d = 0;
          }
          if (paramMessage.d + this.a.jdField_a_of_type_Int > paramMessage.f) {
            paramMessage.d = 0;
          }
          paramMessage.e = (paramMessage.d + this.a.jdField_a_of_type_Int);
          this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoMusic.a(3);
          this.a.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
          this.a.jdField_b_of_type_AndroidViewView.setVisibility(0);
          this.a.jdField_a_of_type_AndroidViewView.setVisibility(0);
          this.a.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
          this.a.jdField_a_of_type_AndroidWidgetTextView.setText(paramMessage.jdField_b_of_type_JavaLangString);
          this.a.a();
          this.a.a(true);
          this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMusicMusicHorizontalSeekView.setDurations((this.a.a() + 500) / 1000, (Math.max(paramMessage.f, this.a.jdField_a_of_type_Int) + 500) / 1000);
          this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMusicMusicHorizontalSeekView.a(paramMessage.d);
          this.a.b(paramMessage.d, paramMessage.e);
        } while ((!this.a.jdField_b_of_type_Boolean) || (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoMusic == null) || (!this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoMusic.jdField_a_of_type_Boolean));
        this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoMusic.au_();
        this.a.jdField_b_of_type_Boolean = false;
        this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoMusic.jdField_a_of_type_Boolean = false;
        return;
        this.a.b();
        paramMessage = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo;
        paramMessage.f = ((int)ShortVideoUtils.a(paramMessage.h));
        if (paramMessage.d < 0) {
          paramMessage.d = 0;
        }
        if (paramMessage.d + this.a.jdField_a_of_type_Int > paramMessage.f) {
          paramMessage.d = 0;
        }
        paramMessage.e = (paramMessage.d + this.a.jdField_a_of_type_Int);
        this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoMusic.a(paramMessage);
        this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoMusic.a(3);
        this.a.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        this.a.jdField_b_of_type_AndroidViewView.setVisibility(0);
        this.a.jdField_a_of_type_AndroidViewView.setVisibility(0);
        this.a.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        this.a.jdField_a_of_type_AndroidWidgetTextView.setText(paramMessage.jdField_b_of_type_JavaLangString);
        this.a.a();
        this.a.a(true);
        this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMusicMusicHorizontalSeekView.setDurations((this.a.a() + 500) / 1000, (Math.max(paramMessage.f, this.a.jdField_a_of_type_Int) + 500) / 1000);
        this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMusicMusicHorizontalSeekView.a(paramMessage.d);
        this.a.b(paramMessage.d, paramMessage.e);
      } while ((!this.a.jdField_b_of_type_Boolean) || (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoMusic == null) || (!this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoMusic.jdField_a_of_type_Boolean));
      this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoMusic.au_();
      this.a.jdField_b_of_type_Boolean = false;
      this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoMusic.jdField_a_of_type_Boolean = false;
      return;
    case 3: 
      this.a.b();
      this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoMusic.a(QQStoryMusicInfo.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo);
      paramMessage = (EditVideoPlayerExport)this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoMusic.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(EditVideoPlayerExport.class);
      if (paramMessage != null) {
        paramMessage.a(true);
      }
      this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoMusic.a(0);
      this.a.jdField_a_of_type_AndroidWidgetTextView.setText("");
      this.a.jdField_b_of_type_AndroidWidgetTextView.setText("当前无任何音效");
      this.a.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.a.jdField_a_of_type_AndroidViewView.setVisibility(8);
      return;
    case 6: 
      paramMessage = (EditVideoPlayerExport)this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoMusic.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(EditVideoPlayerExport.class);
      this.a.b();
      if ((this.a.c) && (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMusicBlessVoiceChangeManager != null))
      {
        if (paramMessage != null) {
          paramMessage.a(true);
        }
        this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMusicBlessVoiceChangeManager.b();
      }
      this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoMusic.a(QQStoryMusicInfo.jdField_b_of_type_DovComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo);
      if (paramMessage != null) {
        paramMessage.a(false);
      }
      this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoMusic.a(1);
      this.a.jdField_a_of_type_AndroidWidgetTextView.setText("");
      this.a.jdField_b_of_type_AndroidWidgetTextView.setText("当前为视频原声");
      this.a.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.a.jdField_a_of_type_AndroidViewView.setVisibility(8);
      return;
    case 7: 
      paramMessage = (String)paramMessage.obj;
      QQToast.a(this.a.getContext(), paramMessage, 0).a();
      return;
    case 8: 
      this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMusicMusicHorizontalSeekView.setPlayedPosition(this.a.jdField_b_of_type_Int);
      return;
    case 9: 
      if (this.a.jdField_a_of_type_AndroidWidgetProgressBar.getVisibility() != 0)
      {
        this.a.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        this.a.jdField_b_of_type_AndroidViewView.setVisibility(8);
      }
      this.a.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(paramMessage.arg1);
      return;
    }
    this.a.b();
    paramMessage = (QQStoryMusicInfo)paramMessage.obj;
    paramMessage.jdField_b_of_type_Int = 4;
    this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoMusic.a(paramMessage);
    EditVideoPlayerExport localEditVideoPlayerExport = (EditVideoPlayerExport)this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoMusic.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(EditVideoPlayerExport.class);
    if (localEditVideoPlayerExport != null) {
      localEditVideoPlayerExport.a(false);
    }
    this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoMusic.a(4);
    this.a.jdField_a_of_type_AndroidWidgetTextView.setText("");
    this.a.jdField_b_of_type_AndroidWidgetTextView.setText("当前变声为" + paramMessage.jdField_b_of_type_JavaLangString);
    this.a.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    this.a.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.a.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aoll
 * JD-Core Version:    0.7.0.1
 */