import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class azgo
  extends RecyclerView.Adapter<azgp>
  implements View.OnClickListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  private azfb jdField_a_of_type_Azfb;
  private azfk jdField_a_of_type_Azfk;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private List<azfv> jdField_a_of_type_JavaUtilList;
  
  public azgo(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    paramContext = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramContext instanceof QQAppInterface)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)paramContext);
    }
  }
  
  private azfv a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return (azfv)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Azfk != null) {
      return this.jdField_a_of_type_Azfk.jdField_a_of_type_Int;
    }
    return -1;
  }
  
  public azfk a()
  {
    return this.jdField_a_of_type_Azfk;
  }
  
  public azgp a(ViewGroup paramViewGroup, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.d("VoiceAdapter", 2, "onCreateViewHolder viewType is error: " + paramInt);
      }
      return new azgp(this, 0, azgu.a(this.jdField_a_of_type_AndroidContentContext));
    case 0: 
      return new azgp(this, paramInt, azgu.a(this.jdField_a_of_type_AndroidContentContext));
    case 1: 
      paramViewGroup = azgu.a(this.jdField_a_of_type_AndroidContentContext, paramViewGroup);
      paramViewGroup.setOnClickListener(this);
      return new azgp(this, paramInt, paramViewGroup);
    case 2: 
      return new azgp(this, paramInt, azgu.b(this.jdField_a_of_type_AndroidContentContext));
    case 3: 
      return new azgp(this, paramInt, azgu.c(this.jdField_a_of_type_AndroidContentContext));
    case 4: 
      return new azgp(this, paramInt, azgu.d(this.jdField_a_of_type_AndroidContentContext));
    case 5: 
      paramViewGroup = azgu.b(this.jdField_a_of_type_AndroidContentContext, paramViewGroup);
      paramViewGroup.findViewById(2131380940).setOnClickListener(this);
      return new azgp(this, paramInt, paramViewGroup);
    case 6: 
      paramViewGroup = azgu.c(this.jdField_a_of_type_AndroidContentContext, paramViewGroup);
      paramViewGroup.findViewById(2131364551).setOnClickListener(this);
      paramViewGroup.findViewById(2131364546).setOnClickListener(this);
      return new azgp(this, paramInt, paramViewGroup);
    case 7: 
      return new azgp(this, paramInt, azgu.a(this.jdField_a_of_type_AndroidContentContext));
    case 8: 
      return new azgp(this, paramInt, azgu.e(this.jdField_a_of_type_AndroidContentContext));
    }
    paramViewGroup = azgu.d(this.jdField_a_of_type_AndroidContentContext, paramViewGroup);
    paramViewGroup.setOnClickListener(this);
    return new azgp(this, paramInt, paramViewGroup);
  }
  
  public List<azfv> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(azfb paramazfb)
  {
    this.jdField_a_of_type_Azfb = paramazfb;
  }
  
  public void a(azfk paramazfk, List<azfv> paramList)
  {
    if (paramList == null) {
      if (QLog.isColorLevel()) {
        QLog.d("VoiceAdapter", 2, "setData list is empty");
      }
    }
    do
    {
      return;
      if ((this.jdField_a_of_type_JavaUtilList == null) || (!paramList.isEmpty())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("VoiceAdapter", 2, "setData do not need refresh");
    return;
    this.jdField_a_of_type_Azfk = paramazfk;
    this.jdField_a_of_type_JavaUtilList = paramList;
    notifyDataSetChanged();
  }
  
  public void a(@NonNull azgp paramazgp, int paramInt)
  {
    Object localObject2 = a(paramInt);
    if (localObject2 != null) {
      switch (paramazgp.jdField_a_of_type_Int)
      {
      case 1: 
      default: 
        if (QLog.isColorLevel()) {
          QLog.d("VoiceAdapter", 2, "onBindViewHolder viewType is error: " + paramazgp.jdField_a_of_type_Int);
        }
        break;
      }
    }
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
                      } while (!(paramazgp.jdField_a_of_type_AndroidViewView instanceof TextView));
                      ((TextView)paramazgp.jdField_a_of_type_AndroidViewView).setText(((azfv)localObject2).jdField_a_of_type_JavaLangString);
                      return;
                    } while (!(paramazgp.jdField_a_of_type_AndroidViewView instanceof TextView));
                    ((TextView)paramazgp.jdField_a_of_type_AndroidViewView).setText(((azfv)localObject2).jdField_a_of_type_JavaLangString);
                    return;
                  } while (!(paramazgp.jdField_a_of_type_AndroidViewView instanceof TextView));
                  ((TextView)paramazgp.jdField_a_of_type_AndroidViewView).setText(((azfv)localObject2).jdField_a_of_type_JavaLangString);
                  return;
                } while (!(paramazgp.jdField_a_of_type_AndroidViewView instanceof TextView));
                ((TextView)paramazgp.jdField_a_of_type_AndroidViewView).setText(((azfv)localObject2).jdField_a_of_type_JavaLangString);
                return;
              } while (paramazgp.jdField_a_of_type_AndroidViewView == null);
              paramazgp = (TextView)paramazgp.jdField_a_of_type_AndroidViewView.findViewById(2131380940);
            } while (paramazgp == null);
            paramazgp.setText(((azfv)localObject2).jdField_a_of_type_JavaLangString);
            return;
          } while (paramazgp.jdField_a_of_type_AndroidViewView == null);
          localObject2 = (TextView)paramazgp.jdField_a_of_type_AndroidViewView.findViewById(2131364546);
          localObject3 = (TextView)paramazgp.jdField_a_of_type_AndroidViewView.findViewById(2131364551);
          if (a() == 5)
          {
            localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131719566);
            paramazgp = this.jdField_a_of_type_AndroidContentContext.getString(2131719592);
          }
          for (;;)
          {
            if (localObject2 != null) {
              ((TextView)localObject2).setText((CharSequence)localObject1);
            }
            if (localObject3 == null) {
              break;
            }
            ((TextView)localObject3).setText(paramazgp);
            return;
            if (a() == 6)
            {
              localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131719590);
              paramazgp = this.jdField_a_of_type_AndroidContentContext.getString(2131719591);
            }
            else
            {
              localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131719567);
              paramazgp = this.jdField_a_of_type_AndroidContentContext.getString(2131719568);
            }
          }
        } while (((azfv)localObject2).jdField_a_of_type_Int != 7);
        paramazgp.jdField_a_of_type_AndroidViewView.setLayoutParams(new ViewGroup.LayoutParams(-1, ScreenUtil.dip2px(((azfv)localObject2).b)));
        return;
      } while (!(paramazgp.jdField_a_of_type_AndroidViewView instanceof TextView));
      ((TextView)paramazgp.jdField_a_of_type_AndroidViewView).setText(((azfv)localObject2).jdField_a_of_type_JavaLangString);
      return;
    } while ((paramazgp.jdField_a_of_type_AndroidViewView == null) || (((azfv)localObject2).jdField_a_of_type_Azfm == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null));
    Object localObject3 = (ImageView)paramazgp.jdField_a_of_type_AndroidViewView.findViewById(2131367258);
    TextView localTextView1 = (TextView)paramazgp.jdField_a_of_type_AndroidViewView.findViewById(2131367276);
    TextView localTextView2 = (TextView)paramazgp.jdField_a_of_type_AndroidViewView.findViewById(2131367259);
    Object localObject1 = null;
    if (((azfv)localObject2).jdField_a_of_type_Azfm.jdField_a_of_type_Int == 0)
    {
      localObject1 = FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, ((azfv)localObject2).jdField_a_of_type_Azfm.jdField_a_of_type_JavaLangString);
      if (localObject1 != null) {
        break label624;
      }
      ((ImageView)localObject3).setImageBitmap(bfvo.a());
    }
    for (;;)
    {
      localTextView1.setText(((azfv)localObject2).jdField_a_of_type_Azfm.b);
      localTextView2.setText(((azfv)localObject2).jdField_a_of_type_Azfm.c);
      paramazgp.jdField_a_of_type_AndroidViewView.setTag(((azfv)localObject2).jdField_a_of_type_Azfm);
      return;
      if (1 != ((azfv)localObject2).jdField_a_of_type_Azfm.jdField_a_of_type_Int) {
        break;
      }
      localObject1 = FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 4, ((azfv)localObject2).jdField_a_of_type_Azfm.jdField_a_of_type_JavaLangString);
      break;
      label624:
      ((ImageView)localObject3).setImageDrawable((Drawable)localObject1);
    }
  }
  
  public int getItemCount()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return this.jdField_a_of_type_JavaUtilList.size();
    }
    return 0;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramInt < this.jdField_a_of_type_JavaUtilList.size()))
    {
      azfv localazfv = (azfv)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      if (localazfv != null) {
        return localazfv.jdField_a_of_type_Int;
      }
    }
    return super.getItemViewType(paramInt);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.jdField_a_of_type_Azfb != null)
      {
        this.jdField_a_of_type_Azfb.a();
        continue;
        if (this.jdField_a_of_type_Azfb != null)
        {
          this.jdField_a_of_type_Azfb.a(true);
          continue;
          if (this.jdField_a_of_type_Azfb != null)
          {
            this.jdField_a_of_type_Azfb.a(false);
            continue;
            if ((this.jdField_a_of_type_Azfb != null) && (this.jdField_a_of_type_Azfk != null))
            {
              this.jdField_a_of_type_Azfb.a(this.jdField_a_of_type_Azfk.jdField_a_of_type_Int);
              continue;
              if ((this.jdField_a_of_type_Azfb != null) && ((paramView.getTag() instanceof azfm)))
              {
                azfm localazfm = (azfm)paramView.getTag();
                this.jdField_a_of_type_Azfb.a(localazfm);
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azgo
 * JD-Core Version:    0.7.0.1
 */