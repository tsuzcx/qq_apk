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

public class bamw
  extends RecyclerView.Adapter<bamx>
  implements View.OnClickListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  private baks jdField_a_of_type_Baks;
  private balb jdField_a_of_type_Balb;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private List<balm> jdField_a_of_type_JavaUtilList;
  
  public bamw(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    paramContext = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramContext instanceof QQAppInterface)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)paramContext);
    }
  }
  
  private balm a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return (balm)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Balb != null) {
      return this.jdField_a_of_type_Balb.jdField_a_of_type_Int;
    }
    return -1;
  }
  
  public balb a()
  {
    return this.jdField_a_of_type_Balb;
  }
  
  public bamx a(ViewGroup paramViewGroup, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.d("VoiceAdapter", 2, "onCreateViewHolder viewType is error: " + paramInt);
      }
      return new bamx(this, 0, banc.a(this.jdField_a_of_type_AndroidContentContext));
    case 0: 
      return new bamx(this, paramInt, banc.a(this.jdField_a_of_type_AndroidContentContext));
    case 1: 
      paramViewGroup = banc.a(this.jdField_a_of_type_AndroidContentContext, paramViewGroup);
      paramViewGroup.setOnClickListener(this);
      return new bamx(this, paramInt, paramViewGroup);
    case 2: 
      return new bamx(this, paramInt, banc.b(this.jdField_a_of_type_AndroidContentContext));
    case 3: 
      return new bamx(this, paramInt, banc.c(this.jdField_a_of_type_AndroidContentContext));
    case 4: 
      return new bamx(this, paramInt, banc.d(this.jdField_a_of_type_AndroidContentContext));
    case 5: 
      paramViewGroup = banc.b(this.jdField_a_of_type_AndroidContentContext, paramViewGroup);
      paramViewGroup.findViewById(2131381292).setOnClickListener(this);
      return new bamx(this, paramInt, paramViewGroup);
    case 6: 
      paramViewGroup = banc.c(this.jdField_a_of_type_AndroidContentContext, paramViewGroup);
      paramViewGroup.findViewById(2131364633).setOnClickListener(this);
      paramViewGroup.findViewById(2131364628).setOnClickListener(this);
      return new bamx(this, paramInt, paramViewGroup);
    case 7: 
      return new bamx(this, paramInt, banc.a(this.jdField_a_of_type_AndroidContentContext));
    case 8: 
      return new bamx(this, paramInt, banc.e(this.jdField_a_of_type_AndroidContentContext));
    }
    paramViewGroup = banc.d(this.jdField_a_of_type_AndroidContentContext, paramViewGroup);
    paramViewGroup.setOnClickListener(this);
    return new bamx(this, paramInt, paramViewGroup);
  }
  
  public List<balm> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(baks parambaks)
  {
    this.jdField_a_of_type_Baks = parambaks;
  }
  
  public void a(balb parambalb, List<balm> paramList)
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
    this.jdField_a_of_type_Balb = parambalb;
    this.jdField_a_of_type_JavaUtilList = paramList;
    notifyDataSetChanged();
  }
  
  public void a(@NonNull bamx parambamx, int paramInt)
  {
    Object localObject2 = a(paramInt);
    if (localObject2 != null) {
      switch (parambamx.jdField_a_of_type_Int)
      {
      case 1: 
      default: 
        if (QLog.isColorLevel()) {
          QLog.d("VoiceAdapter", 2, "onBindViewHolder viewType is error: " + parambamx.jdField_a_of_type_Int);
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
                      } while (!(parambamx.jdField_a_of_type_AndroidViewView instanceof TextView));
                      ((TextView)parambamx.jdField_a_of_type_AndroidViewView).setText(((balm)localObject2).jdField_a_of_type_JavaLangString);
                      return;
                    } while (!(parambamx.jdField_a_of_type_AndroidViewView instanceof TextView));
                    ((TextView)parambamx.jdField_a_of_type_AndroidViewView).setText(((balm)localObject2).jdField_a_of_type_JavaLangString);
                    return;
                  } while (!(parambamx.jdField_a_of_type_AndroidViewView instanceof TextView));
                  ((TextView)parambamx.jdField_a_of_type_AndroidViewView).setText(((balm)localObject2).jdField_a_of_type_JavaLangString);
                  return;
                } while (!(parambamx.jdField_a_of_type_AndroidViewView instanceof TextView));
                ((TextView)parambamx.jdField_a_of_type_AndroidViewView).setText(((balm)localObject2).jdField_a_of_type_JavaLangString);
                return;
              } while (parambamx.jdField_a_of_type_AndroidViewView == null);
              parambamx = (TextView)parambamx.jdField_a_of_type_AndroidViewView.findViewById(2131381292);
            } while (parambamx == null);
            parambamx.setText(((balm)localObject2).jdField_a_of_type_JavaLangString);
            return;
          } while (parambamx.jdField_a_of_type_AndroidViewView == null);
          localObject2 = (TextView)parambamx.jdField_a_of_type_AndroidViewView.findViewById(2131364628);
          localObject3 = (TextView)parambamx.jdField_a_of_type_AndroidViewView.findViewById(2131364633);
          if (a() == 5)
          {
            localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131720019);
            parambamx = this.jdField_a_of_type_AndroidContentContext.getString(2131720045);
          }
          for (;;)
          {
            if (localObject2 != null) {
              ((TextView)localObject2).setText((CharSequence)localObject1);
            }
            if (localObject3 == null) {
              break;
            }
            ((TextView)localObject3).setText(parambamx);
            return;
            if (a() == 6)
            {
              localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131720043);
              parambamx = this.jdField_a_of_type_AndroidContentContext.getString(2131720044);
            }
            else
            {
              localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131720020);
              parambamx = this.jdField_a_of_type_AndroidContentContext.getString(2131720021);
            }
          }
        } while (((balm)localObject2).jdField_a_of_type_Int != 7);
        parambamx.jdField_a_of_type_AndroidViewView.setLayoutParams(new ViewGroup.LayoutParams(-1, ScreenUtil.dip2px(((balm)localObject2).b)));
        return;
      } while (!(parambamx.jdField_a_of_type_AndroidViewView instanceof TextView));
      ((TextView)parambamx.jdField_a_of_type_AndroidViewView).setText(((balm)localObject2).jdField_a_of_type_JavaLangString);
      return;
    } while ((parambamx.jdField_a_of_type_AndroidViewView == null) || (((balm)localObject2).jdField_a_of_type_Bald == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null));
    Object localObject3 = (ImageView)parambamx.jdField_a_of_type_AndroidViewView.findViewById(2131367382);
    TextView localTextView1 = (TextView)parambamx.jdField_a_of_type_AndroidViewView.findViewById(2131367400);
    TextView localTextView2 = (TextView)parambamx.jdField_a_of_type_AndroidViewView.findViewById(2131367383);
    Object localObject1 = null;
    if (((balm)localObject2).jdField_a_of_type_Bald.jdField_a_of_type_Int == 0)
    {
      localObject1 = FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, ((balm)localObject2).jdField_a_of_type_Bald.jdField_a_of_type_JavaLangString);
      if (localObject1 != null) {
        break label624;
      }
      ((ImageView)localObject3).setImageBitmap(bheg.a());
    }
    for (;;)
    {
      localTextView1.setText(((balm)localObject2).jdField_a_of_type_Bald.b);
      localTextView2.setText(((balm)localObject2).jdField_a_of_type_Bald.c);
      parambamx.jdField_a_of_type_AndroidViewView.setTag(((balm)localObject2).jdField_a_of_type_Bald);
      return;
      if (1 != ((balm)localObject2).jdField_a_of_type_Bald.jdField_a_of_type_Int) {
        break;
      }
      localObject1 = FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 4, ((balm)localObject2).jdField_a_of_type_Bald.jdField_a_of_type_JavaLangString);
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
      balm localbalm = (balm)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      if (localbalm != null) {
        return localbalm.jdField_a_of_type_Int;
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
      if (this.jdField_a_of_type_Baks != null)
      {
        this.jdField_a_of_type_Baks.a();
        continue;
        if (this.jdField_a_of_type_Baks != null)
        {
          this.jdField_a_of_type_Baks.a(true);
          continue;
          if (this.jdField_a_of_type_Baks != null)
          {
            this.jdField_a_of_type_Baks.a(false);
            continue;
            if ((this.jdField_a_of_type_Baks != null) && (this.jdField_a_of_type_Balb != null))
            {
              this.jdField_a_of_type_Baks.a(this.jdField_a_of_type_Balb.jdField_a_of_type_Int);
              continue;
              if ((this.jdField_a_of_type_Baks != null) && ((paramView.getTag() instanceof bald)))
              {
                bald localbald = (bald)paramView.getTag();
                this.jdField_a_of_type_Baks.a(localbald);
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bamw
 * JD-Core Version:    0.7.0.1
 */