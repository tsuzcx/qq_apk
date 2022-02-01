import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;

class awyw
  implements awzc<PicEmoticonInfo>
{
  awyw(awyr paramawyr, boolean paramBoolean, SessionInfo paramSessionInfo) {}
  
  public void a(PicEmoticonInfo paramPicEmoticonInfo)
  {
    if ((paramPicEmoticonInfo != null) && (paramPicEmoticonInfo.emoticon != null))
    {
      if (this.jdField_a_of_type_Boolean) {
        awyr.a(this.jdField_a_of_type_Awyr.a, "0X800A937", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, paramPicEmoticonInfo.emoticon.epId);
      }
    }
    else {
      return;
    }
    awyr.a(this.jdField_a_of_type_Awyr.a, "0X800A936", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, paramPicEmoticonInfo.emoticon.epId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awyw
 * JD-Core Version:    0.7.0.1
 */