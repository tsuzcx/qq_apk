import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.GridView;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.AppRuntime;

public class aodj
  extends BaseAdapter
  implements aodu, URLDrawableDownListener
{
  public static final Object a;
  public static final Object b;
  public static final Object c;
  int jdField_a_of_type_Int = 4;
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private aodq jdField_a_of_type_Aodq;
  private GridView jdField_a_of_type_ComTencentWidgetGridView;
  private String jdField_a_of_type_JavaLangString;
  private Calendar jdField_a_of_type_JavaUtilCalendar;
  private HashMap<MessageForPic, aodt> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  List<Object> jdField_a_of_type_JavaUtilList = new ArrayList();
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int = -1;
  private List<MessageRecord> jdField_b_of_type_JavaUtilList;
  public boolean b;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean = true;
  private int d;
  
  static
  {
    jdField_a_of_type_JavaLangObject = new Object();
    jdField_b_of_type_JavaLangObject = new Object();
    jdField_c_of_type_JavaLangObject = new Object();
  }
  
  public aodj(Activity paramActivity, aodq paramaodq, Handler paramHandler, int paramInt, GridView paramGridView)
  {
    this.jdField_a_of_type_AndroidContentContext = paramActivity;
    this.jdField_a_of_type_Aodq = paramaodq;
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentWidgetGridView = paramGridView;
    this.jdField_a_of_type_AndroidViewLayoutInflater = paramActivity.getLayoutInflater();
    this.d = actn.a(30.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
  }
  
  private ayov a(MessageForPic paramMessageForPic)
  {
    boolean bool = true;
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface)))
    {
      aunl localaunl = new aunl();
      localaunl.e = paramMessageForPic.fileSizeFlag;
      if (localaunl.e == 1) {}
      for (;;)
      {
        int i = aywk.a("aiothumb", bool);
        paramMessageForPic = ((QQAppInterface)localAppRuntime).a().a(ayvv.a(paramMessageForPic.md5, paramMessageForPic.uuid, i));
        if ((paramMessageForPic == null) || (!(paramMessageForPic instanceof ayov))) {
          break;
        }
        return (ayov)paramMessageForPic;
        bool = false;
      }
    }
    return null;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object a(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  String a(Calendar paramCalendar, long paramLong)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(1000L * paramLong);
    int i = paramCalendar.get(1);
    int j = localCalendar.get(1);
    int k = localCalendar.get(2);
    if ((i == j) && (paramCalendar.get(6) - localCalendar.get(6) < 7)) {
      return "7天内";
    }
    return String.format(Locale.CHINA, "%d年%d月", new Object[] { Integer.valueOf(j), Integer.valueOf(k + 1) });
  }
  
  public List<MessageRecord> a()
  {
    return this.jdField_b_of_type_JavaUtilList;
  }
  
  public void a()
  {
    if (!this.jdField_a_of_type_JavaUtilHashMap.isEmpty())
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        ayov localayov = a((MessageForPic)localEntry.getKey());
        if (localayov != null) {
          localayov.a((aumy)localEntry.getValue());
        }
      }
    }
  }
  
  public void a(int paramInt, View paramView)
  {
    Object localObject2 = getItem(paramInt);
    Object localObject1 = paramView.getTag();
    if (!aodw.class.isInstance(localObject2))
    {
      QLog.d("ChatHistoryEmotionAdapter", 2, "[updateView] is not AIORichMediaInfo, position:" + paramInt);
      return;
    }
    if (!(localObject1 instanceof aodk))
    {
      QLog.d("ChatHistoryEmotionAdapter", 2, "[updateView] is not ContentHolder, position:" + paramInt);
      return;
    }
    localObject1 = (aodk)localObject1;
    localObject2 = (aodw)localObject2;
    Object localObject3 = ((aodk)localObject1).jdField_a_of_type_ComTencentImageURLImageView;
    Object localObject4 = this.jdField_a_of_type_Aodq;
    localObject4 = aodq.a(this.jdField_a_of_type_AndroidContentContext, (aodw)localObject2);
    if (((aodw)localObject2).jdField_b_of_type_Boolean)
    {
      if (((aodw)localObject2).jdField_c_of_type_Boolean) {
        ((URLImageView)localObject3).setURLDrawableDownListener(this);
      }
    }
    else
    {
      if ((!(localObject4 instanceof asbz)) || (((asbz)localObject4).a() == null)) {
        break label338;
      }
      ((URLImageView)localObject3).setImageBitmap(aodp.a(((asbz)localObject4).a(), this.jdField_c_of_type_Int, this.jdField_c_of_type_Int));
      label188:
      localObject3 = ((aodk)localObject1).jdField_a_of_type_AndroidWidgetImageView;
      localObject1 = ((aodk)localObject1).b;
      if (!this.jdField_b_of_type_Boolean) {
        break label371;
      }
      if (!((aodw)localObject2).jdField_a_of_type_Boolean) {
        break label348;
      }
      ((ImageView)localObject3).setVisibility(0);
      ((ImageView)localObject1).setImageResource(2130844861);
      ((ImageView)localObject1).setVisibility(0);
    }
    for (;;)
    {
      int i = paramInt / 4;
      paramView.setContentDescription(ajyc.a(2131701599) + (i + 1) + ajyc.a(2131701659) + (paramInt % 4 + 1) + ajyc.a(2131701640));
      return;
      if (ayog.a(aywk.a((MessageForPic)((aodw)localObject2).jdField_a_of_type_ComTencentMobileqqDataMessageRecord, 65537).toString()) != null) {
        break;
      }
      a((MessageForPic)((aodw)localObject2).jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
      break;
      label338:
      ((URLImageView)localObject3).setImageDrawable((Drawable)localObject4);
      break label188;
      label348:
      ((ImageView)localObject3).setVisibility(4);
      ((ImageView)localObject1).setImageResource(2130844858);
      ((ImageView)localObject1).setVisibility(0);
      continue;
      label371:
      ((ImageView)localObject3).setVisibility(4);
      ((ImageView)localObject1).setVisibility(4);
    }
  }
  
  public void a(int paramInt, MessageForPic paramMessageForPic) {}
  
  public void a(MessageForPic paramMessageForPic)
  {
    aodt localaodt = new aodt(paramMessageForPic, this.jdField_a_of_type_AndroidOsHandler, this);
    if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramMessageForPic)) {
      this.jdField_a_of_type_JavaUtilHashMap.put(paramMessageForPic, localaodt);
    }
    Object localObject = a(paramMessageForPic);
    if (localObject != null) {
      ((ayov)localObject).b(localaodt);
    }
    do
    {
      return;
      localObject = aunj.a(5, 1536, 1);
      ((aunt)localObject).a(paramMessageForPic, paramMessageForPic.getPicDownloadInfo());
      ((aunt)localObject).a(localaodt);
      paramMessageForPic = BaseApplicationImpl.getApplication().getRuntime();
    } while ((paramMessageForPic == null) || (!(paramMessageForPic instanceof QQAppInterface)));
    aunj.a((aunt)localObject, (QQAppInterface)paramMessageForPic);
  }
  
  public void a(List<MessageRecord> paramList)
  {
    this.jdField_b_of_type_JavaUtilList.addAll(paramList);
    a(false, paramList);
    a(false);
    notifyDataSetChanged();
  }
  
  public void a(boolean paramBoolean, MessageForPic paramMessageForPic)
  {
    this.jdField_a_of_type_JavaUtilHashMap.remove(paramMessageForPic);
    notifyDataSetChanged();
  }
  
  public void a(boolean paramBoolean, List<MessageRecord> paramList)
  {
    if (this.jdField_a_of_type_Int == 0) {}
    for (;;)
    {
      return;
      if (paramBoolean)
      {
        this.jdField_a_of_type_JavaUtilList.clear();
        this.jdField_b_of_type_Int = -1;
        if (this.jdField_a_of_type_Boolean) {
          this.jdField_a_of_type_JavaLangString = null;
        }
      }
      if (this.jdField_a_of_type_JavaUtilCalendar == null)
      {
        this.jdField_a_of_type_JavaUtilCalendar = Calendar.getInstance();
        this.jdField_a_of_type_JavaUtilCalendar.setTimeInMillis(awzw.a() * 1000L);
      }
      int i = paramList.size() - 1;
      while (i >= 0)
      {
        Object localObject = (MessageRecord)paramList.get(i);
        aodw localaodw = new aodw((MessageRecord)localObject);
        localObject = a(this.jdField_a_of_type_JavaUtilCalendar, ((MessageRecord)localObject).time);
        if (!((String)localObject).equals(this.jdField_a_of_type_JavaLangString))
        {
          this.jdField_a_of_type_JavaLangString = ((String)localObject);
          if (this.jdField_b_of_type_Int != -1)
          {
            int k = this.jdField_b_of_type_Int % this.jdField_a_of_type_Int;
            if (k > 0)
            {
              j = 0;
              while (j < this.jdField_a_of_type_Int - k)
              {
                this.jdField_a_of_type_JavaUtilList.add(jdField_c_of_type_JavaLangObject);
                j += 1;
              }
            }
          }
          this.jdField_b_of_type_Int = 0;
          this.jdField_a_of_type_JavaUtilList.add(localObject);
          int j = 0;
          while (j < this.jdField_a_of_type_Int - 1)
          {
            this.jdField_a_of_type_JavaUtilList.add(jdField_b_of_type_JavaLangObject);
            j += 1;
          }
        }
        this.jdField_a_of_type_JavaUtilList.add(localaodw);
        this.jdField_b_of_type_Int += 1;
        i -= 1;
      }
    }
  }
  
  public boolean a(boolean paramBoolean)
  {
    if (paramBoolean != this.jdField_c_of_type_Boolean)
    {
      this.jdField_c_of_type_Boolean = paramBoolean;
      return true;
    }
    return false;
  }
  
  public void b(List<MessageRecord> paramList)
  {
    this.jdField_b_of_type_JavaUtilList = paramList;
    a(true, this.jdField_b_of_type_JavaUtilList);
    a(false);
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    int i = this.jdField_a_of_type_JavaUtilList.size();
    int j = i;
    if (this.jdField_c_of_type_Boolean)
    {
      int k = i % 4;
      j = i;
      if (k > 0) {
        j = i + (4 - k);
      }
      j += 1;
    }
    return j;
  }
  
  public Object getItem(int paramInt)
  {
    if (!this.jdField_c_of_type_Boolean) {
      return this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size()) {
      return this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    if (paramInt == getCount() - 1) {
      return jdField_a_of_type_JavaLangObject;
    }
    return jdField_c_of_type_JavaLangObject;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    Object localObject = getItem(paramInt);
    if ((localObject instanceof MessageRecord)) {}
    do
    {
      return 0;
      if (jdField_c_of_type_JavaLangObject.equals(localObject)) {
        return 1;
      }
      if ((localObject instanceof String)) {
        return 2;
      }
      if (jdField_b_of_type_JavaLangObject.equals(localObject)) {
        return 3;
      }
    } while (!jdField_a_of_type_JavaLangObject.equals(localObject));
    return 4;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = getItemViewType(paramInt);
    if (paramView == null)
    {
      paramViewGroup = null;
      switch (i)
      {
      default: 
        label48:
        switch (i)
        {
        }
        break;
      }
    }
    Object localObject1;
    do
    {
      do
      {
        do
        {
          do
          {
            return paramView;
            paramViewGroup = paramView.getTag();
            break;
            if (aodk.class.isInstance(paramViewGroup)) {
              break label48;
            }
            if ((QLog.isColorLevel()) && (paramView != null))
            {
              paramView = (AbsListView.LayoutParams)paramView.getLayoutParams();
              QLog.d("ChatHistoryEmotionAdapter", 2, "[getView] type 0 while convertView type " + paramView.jdField_a_of_type_Int);
            }
            paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559016, null);
            paramView.setLayoutParams(new AbsListView.LayoutParams(this.jdField_c_of_type_Int, this.jdField_c_of_type_Int));
            localObject1 = new aodk(this);
            ((aodk)localObject1).jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131371559));
            ((aodk)localObject1).jdField_a_of_type_ComTencentImageURLImageView.setAdjustViewBounds(false);
            ((aodk)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131371563));
            ((aodk)localObject1).b = ((ImageView)paramView.findViewById(2131371564));
            paramView.setTag(localObject1);
            break label48;
            if (jdField_c_of_type_JavaLangObject.equals(paramViewGroup)) {
              break label48;
            }
            paramView = new View(this.jdField_a_of_type_AndroidContentContext);
            paramView.setLayoutParams(new AbsListView.LayoutParams(this.jdField_c_of_type_Int, this.jdField_c_of_type_Int));
            paramView.setTag(jdField_c_of_type_JavaLangObject);
            break label48;
            if (aodm.class.isInstance(paramViewGroup)) {
              break label48;
            }
            localObject1 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560948, null);
            paramViewGroup = new aodm(this);
            paramViewGroup.a = ((TextView)((View)localObject1).findViewById(2131377188));
            paramView = new aodl(this, this.jdField_a_of_type_AndroidContentContext);
            Object localObject2 = ((View)localObject1).getLayoutParams();
            if (localObject2 != null)
            {
              ((View)localObject1).setLayoutParams(new FrameLayout.LayoutParams(((ViewGroup.LayoutParams)localObject2).width, ((ViewGroup.LayoutParams)localObject2).height));
              paramView.setLayoutParams(new AbsListView.LayoutParams(((ViewGroup.LayoutParams)localObject2).width, ((ViewGroup.LayoutParams)localObject2).height));
            }
            ((FrameLayout)paramView).addView((View)localObject1);
            paramView.setTag(paramViewGroup);
            break label48;
            if (jdField_b_of_type_JavaLangObject.equals(paramViewGroup)) {
              break label48;
            }
            paramView = new View(this.jdField_a_of_type_AndroidContentContext);
            paramView.setMinimumHeight(this.d);
            paramView.setVisibility(4);
            paramView.setTag(jdField_b_of_type_JavaLangObject);
            break label48;
            if (jdField_a_of_type_JavaLangObject.equals(paramViewGroup)) {
              break label48;
            }
            paramView = new aodl(this, this.jdField_a_of_type_AndroidContentContext);
            localObject1 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560947, null);
            localObject2 = new FrameLayout.LayoutParams(-2, -2);
            ((FrameLayout.LayoutParams)localObject2).gravity = 17;
            ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
            paramView.addView((View)localObject1);
            paramView.setTag(jdField_a_of_type_JavaLangObject);
            break label48;
          } while (paramView == null);
          a(paramInt, paramView);
          return paramView;
        } while (!aodm.class.isInstance(paramViewGroup));
        paramViewGroup = (aodm)paramViewGroup;
      } while (paramViewGroup == null);
      localObject1 = (String)getItem(paramInt);
      paramViewGroup.a.setText((CharSequence)localObject1);
    } while (!AppSetting.d);
    paramInt /= 4;
    paramViewGroup.a.setContentDescription(ajyc.a(2131701641) + (paramInt + 1) + ajyc.a(2131701593) + (String)localObject1);
    return paramView;
  }
  
  public int getViewTypeCount()
  {
    return 5;
  }
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable) {}
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException) {}
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    try
    {
      File localFile = paramURLDrawable.getFileInLocal();
      if (localFile == null) {
        break label63;
      }
      i = bbdr.c(localFile.getAbsolutePath());
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        label63:
        int i = 0;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ChatHistoryEmotionAdapter", 2, new Object[] { "onLoadSuccessed,orientation:", Integer.valueOf(i) });
    }
    AIOGalleryAdapter.a(paramView, paramURLDrawable, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aodj
 * JD-Core Version:    0.7.0.1
 */