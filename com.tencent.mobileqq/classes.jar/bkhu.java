import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.qidian.QidianProfileCardActivity;
import com.tencent.qidian.QidianProfileCardActivity.QidianSimpleProfileItem;
import java.util.List;

public class bkhu
  extends Handler
{
  public bkhu(QidianProfileCardActivity paramQidianProfileCardActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      super.handleMessage(paramMessage);
      return;
      try
      {
        BitmapDrawable localBitmapDrawable = new BitmapDrawable(this.a.getResources(), this.a.jdField_a_of_type_AndroidGraphicsBitmap);
        this.a.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(localBitmapDrawable);
      }
      catch (Exception localException) {}
      continue;
      Object localObject = (QidianProfileCardActivity.QidianSimpleProfileItem)paramMessage.getData().getParcelable("data");
      localObject = this.a.a((QidianProfileCardActivity.QidianSimpleProfileItem)localObject);
      if (localObject != null)
      {
        this.a.b.addView((View)localObject);
        continue;
        localObject = paramMessage.getData().getParcelableArrayList("data");
        localObject = this.a.a((List)localObject);
        if (localObject != null)
        {
          LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
          localLayoutParams.leftMargin = this.a.d;
          ((View)localObject).setPadding(0, this.a.e, this.a.d, this.a.e);
          this.a.b.addView((View)localObject, localLayoutParams);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkhu
 * JD-Core Version:    0.7.0.1
 */