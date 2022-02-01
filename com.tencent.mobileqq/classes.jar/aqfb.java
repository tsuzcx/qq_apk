import com.tencent.image.URLDrawable;
import com.tencent.image.VideoDrawable;
import com.tencent.image.VideoDrawable.OnPlayRepeatListener;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView;
import com.tencent.qphone.base.util.QLog;

public class aqfb
  implements VideoDrawable.OnPlayRepeatListener
{
  public aqfb(DynamicAvatarView paramDynamicAvatarView) {}
  
  public void onPlayRepeat(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.dynamicAvatar", 2, "onPlayRepeat: " + paramInt);
    }
    if ((this.a.b) || (paramInt < 1)) {}
    while (this.a.a == null) {
      return;
    }
    Object localObject = this.a.a.jdField_a_of_type_ComTencentImageURLDrawable;
    if ((localObject instanceof URLDrawable))
    {
      localObject = ((URLDrawable)localObject).getCurrDrawable();
      if ((localObject instanceof VideoDrawable))
      {
        ((VideoDrawable)localObject).removeOnPlayRepeatListener(this);
        this.a.a.jdField_a_of_type_Aqeq.a(this.a.a, true);
        if (QLog.isColorLevel()) {
          QLog.e("Q.dynamicAvatar", 2, "removeOnPlayRepeatListener.03");
        }
      }
    }
    this.a.a.jdField_a_of_type_ComTencentImageURLDrawable = null;
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqfb
 * JD-Core Version:    0.7.0.1
 */