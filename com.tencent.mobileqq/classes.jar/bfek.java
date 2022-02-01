import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.mobileqq.app.face.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.troop.widget.AddedRobotView;
import com.tencent.qphone.base.util.QLog;

public class bfek
  implements FaceDecoder.DecodeTaskCompletionListener
{
  public bfek(AddedRobotView paramAddedRobotView) {}
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    QLog.i("AddedRobotView", 1, "onDecodeTaskCompleted uin: " + paramString);
    if (AddedRobotView.a(this.a) == null) {}
    for (;;)
    {
      return;
      if (!AddedRobotView.a(this.a).isPausing())
      {
        paramInt2 = AddedRobotView.a(this.a).getChildCount();
        paramInt1 = 0;
        while (paramInt1 < paramInt2)
        {
          Object localObject = AddedRobotView.a(this.a).getChildViewHolder(AddedRobotView.a(this.a).getChildAt(paramInt1));
          if ((localObject instanceof bfen))
          {
            localObject = (bfen)localObject;
            if ((!TextUtils.isEmpty(((bfen)localObject).jdField_a_of_type_JavaLangString)) && (((bfen)localObject).jdField_a_of_type_JavaLangString.equals(paramString))) {
              ((bfen)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
            }
          }
          else
          {
            QLog.i("AddedRobotView", 2, "onDecodeTaskCompleted viewHolder correct uin not found ! ");
          }
          paramInt1 += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfek
 * JD-Core Version:    0.7.0.1
 */