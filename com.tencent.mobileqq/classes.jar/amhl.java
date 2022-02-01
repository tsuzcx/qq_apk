import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.ImageProgressCircle;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.net.MalformedURLException;
import java.net.URL;
import mqq.os.MqqHandler;

public class amhl
  extends BaseAdapter
  implements Handler.Callback
{
  int jdField_a_of_type_Int;
  aebb jdField_a_of_type_Aebb;
  Context jdField_a_of_type_AndroidContentContext;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  boolean jdField_a_of_type_Boolean = false;
  Drawable b;
  
  public amhl(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = ((int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131297492));
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130850820);
    this.b = paramContext.getResources().getDrawable(2130850821);
    this.jdField_a_of_type_MqqOsMqqHandler = new bhde(Looper.getMainLooper(), this);
  }
  
  public void a()
  {
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1);
  }
  
  public void a(aebb paramaebb)
  {
    this.jdField_a_of_type_Aebb = paramaebb;
  }
  
  public void a(aebd paramaebd, View paramView)
  {
    if (paramView == null) {}
    do
    {
      return;
      a(paramView);
      paramView.setTag(paramaebd.b);
      paramaebd = (ImageView)paramView.findViewById(2131368501);
    } while (paramaebd == null);
    paramaebd.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
  }
  
  public void a(View paramView)
  {
    if (paramView == null) {}
    do
    {
      do
      {
        return;
        paramView = (ImageProgressCircle)paramView.findViewById(2131368600);
      } while (paramView == null);
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1, paramView);
    } while (paramView.getVisibility() == 4);
    paramView.setVisibility(4);
  }
  
  public void a(ImageProgressCircle paramImageProgressCircle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.PhotoWall", 2, "showProgress() progressCircle = " + paramImageProgressCircle);
    }
    if (paramImageProgressCircle == null) {}
    while (this.jdField_a_of_type_MqqOsMqqHandler.hasMessages(1, paramImageProgressCircle)) {
      return;
    }
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    localMessage.obj = paramImageProgressCircle;
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(localMessage, 550L);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void b(aebd paramaebd, View paramView)
  {
    Object localObject1 = null;
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.PhotoWall", 2, "loadThumbImage() path = " + paramaebd.b);
    }
    try
    {
      URL localURL = new URL("profile_img_thumb", null, paramaebd.b);
      if (this.jdField_a_of_type_Aebb != null) {
        localObject1 = this.jdField_a_of_type_Aebb.a();
      }
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = this.b;
      }
      localObject1 = URLDrawable.getDrawable(localURL, (Drawable)localObject2, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      paramView.setTag(paramaebd.b);
      ((ImageView)paramView.findViewById(2131368501)).setImageDrawable((Drawable)localObject1);
      return;
    }
    catch (MalformedURLException paramaebd)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.profilecard.PhotoWall", 2, paramaebd.toString());
    }
  }
  
  public void c(aebd paramaebd, View paramView)
  {
    int i = 1;
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.PhotoWall", 2, "loadBigImage() path = " + paramaebd.c);
    }
    if (paramView == null) {
      return;
    }
    URL localURL;
    for (;;)
    {
      try
      {
        a(paramView);
        localObject1 = URLDrawable.getDrawable(new URL("profile_img_thumb", null, paramaebd.b));
        localURL = new URL("profile_img_big_fhd", null, paramaebd.c);
        if (((URLDrawable)localObject1).getStatus() == 1)
        {
          if (i == 0) {
            break label164;
          }
          localObject1 = URLDrawable.getDrawable(localURL, (Drawable)localObject1, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
          paramView.setTag(paramaebd.c);
          paramaebd = (ImageView)paramView.findViewById(2131368501);
          if (paramaebd == null) {
            break;
          }
          paramaebd.setImageDrawable((Drawable)localObject1);
          return;
        }
      }
      catch (MalformedURLException paramaebd)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.PhotoWall", 2, paramaebd.toString());
        }
        paramView.setTag(null);
        return;
      }
      i = 0;
    }
    label164:
    if (this.jdField_a_of_type_Aebb != null) {}
    for (Object localObject1 = this.jdField_a_of_type_Aebb.a();; localObject1 = null)
    {
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = this.b;
      }
      localObject1 = URLDrawable.getDrawable(localURL, (Drawable)localObject2, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      break;
    }
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_Aebb != null) {
      return this.jdField_a_of_type_Aebb.a();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    if (this.jdField_a_of_type_Aebb != null) {
      return this.jdField_a_of_type_Aebb.a(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject = paramView;
    View localView;
    ImageView localImageView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559308, null);
      paramView = (ImageProgressCircle)localView.findViewById(2131368600);
      paramView.setVisibility(4);
      localImageView = (ImageView)localView.findViewById(2131368501);
      localImageView.setMinimumWidth(this.jdField_a_of_type_Int);
      localImageView.setMinimumHeight(this.jdField_a_of_type_Int);
      localObject = (aebd)getItem(paramInt);
      if (localObject != null)
      {
        if (!this.jdField_a_of_type_Boolean) {
          break label176;
        }
        localObject = this.jdField_a_of_type_Aebb.a.getTroopFaceDrawable(this.jdField_a_of_type_Aebb.b, (byte)1, false, false);
        paramView = (View)localObject;
        if (localObject == null) {
          paramView = bheg.c();
        }
        localImageView.setImageDrawable(paramView);
      }
    }
    for (;;)
    {
      localObject = localView;
      if (AppSetting.c)
      {
        localImageView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131691154));
        localObject = localView;
      }
      EventCollector.getInstance().onListGetView(paramInt, (View)localObject, paramViewGroup, getItemId(paramInt));
      return localObject;
      label176:
      if (((aebd)localObject).jdField_a_of_type_Int == 6)
      {
        c((aebd)localObject, localView);
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.PhotoWall", 2, paramInt + "," + ((aebd)localObject).c);
        }
      }
      else if ((((aebd)localObject).jdField_a_of_type_Int == 3) || (((aebd)localObject).jdField_a_of_type_Int == 4))
      {
        b((aebd)localObject, localView);
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.PhotoWall", 2, "thumb: " + paramInt + "," + ((aebd)localObject).b);
        }
        if (((aebd)localObject).jdField_a_of_type_Boolean) {
          a(paramView);
        }
      }
      else
      {
        localImageView.setImageResource(2130850821);
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if ((paramMessage.what == 1) && ((paramMessage.obj instanceof ImageProgressCircle)))
    {
      paramMessage = (ImageProgressCircle)paramMessage.obj;
      if (paramMessage.getVisibility() != 0) {
        paramMessage.setVisibility(0);
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amhl
 * JD-Core Version:    0.7.0.1
 */