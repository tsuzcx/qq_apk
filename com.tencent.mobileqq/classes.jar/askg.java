import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.BasePicDownloadProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
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

public class askg
  extends BaseAdapter
  implements asks, URLDrawableDownListener
{
  public static final Object a;
  public static final Object b;
  public static final Object c;
  int jdField_a_of_type_Int = 4;
  private ahtk jdField_a_of_type_Ahtk = new ahtk();
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private asko jdField_a_of_type_Asko;
  private GridView jdField_a_of_type_ComTencentWidgetGridView;
  private String jdField_a_of_type_JavaLangString;
  private Calendar jdField_a_of_type_JavaUtilCalendar;
  private HashMap<MessageForPic, askr> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  List<Object> jdField_a_of_type_JavaUtilList = new ArrayList();
  public boolean a;
  int jdField_b_of_type_Int = -1;
  private List<MessageRecord> jdField_b_of_type_JavaUtilList;
  private boolean jdField_b_of_type_Boolean = true;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private int d;
  private int e = -1;
  private int f = -1;
  
  static
  {
    jdField_a_of_type_JavaLangObject = new Object();
    jdField_b_of_type_JavaLangObject = new Object();
    jdField_c_of_type_JavaLangObject = new Object();
  }
  
  public askg(Activity paramActivity, asko paramasko, Handler paramHandler, int paramInt, GridView paramGridView)
  {
    this.jdField_a_of_type_AndroidContentContext = paramActivity;
    this.jdField_a_of_type_Asko = paramasko;
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentWidgetGridView = paramGridView;
    this.jdField_a_of_type_AndroidViewLayoutInflater = paramActivity.getLayoutInflater();
    this.d = AIOUtils.dp2px(40.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
  }
  
  private BasePicDownloadProcessor a(MessageForPic paramMessageForPic)
  {
    boolean bool = true;
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface)))
    {
      azjx localazjx = new azjx();
      localazjx.e = paramMessageForPic.fileSizeFlag;
      if (localazjx.e == 1) {}
      for (;;)
      {
        int i = URLDrawableHelper.getFileSizeType("aiothumb", bool);
        paramMessageForPic = ((QQAppInterface)localAppRuntime).getTransFileController().findProcessor(TransFileController.makeReceiveKey(paramMessageForPic.md5, paramMessageForPic.uuid, i));
        if ((paramMessageForPic == null) || (!(paramMessageForPic instanceof BasePicDownloadProcessor))) {
          break;
        }
        return (BasePicDownloadProcessor)paramMessageForPic;
        bool = false;
      }
    }
    return null;
  }
  
  private void a(int paramInt1, View paramView, int paramInt2, Object paramObject)
  {
    switch (paramInt2)
    {
    }
    String str;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
          } while (paramView == null);
          a(paramInt1, paramView);
          return;
        } while (!askk.class.isInstance(paramObject));
        paramObject = (askk)paramObject;
      } while (paramObject == null);
      str = (String)getItem(paramInt1);
      paramObject.jdField_a_of_type_AndroidWidgetTextView.setText(str);
      if (AppSetting.jdField_c_of_type_Boolean)
      {
        paramInt1 /= 4;
        paramObject.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(anvx.a(2131701150) + (paramInt1 + 1) + anvx.a(2131701102) + str);
      }
    } while (!a());
    ViewGroup localViewGroup = (ViewGroup)paramObject.jdField_a_of_type_AndroidWidgetCheckBox.getParent();
    if (localViewGroup != null) {
      localViewGroup.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839453));
    }
    paramObject.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
    paramObject.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(this.jdField_a_of_type_Ahtk.a(str));
    paramObject.jdField_a_of_type_AndroidWidgetCheckBox.setClickable(false);
    paramView.setOnClickListener(new askh(this, str));
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
    if (this.jdField_a_of_type_Ahtk.a(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_Int)) {
      notifyDataSetChanged();
    }
  }
  
  public void a(int paramInt)
  {
    this.e = paramInt;
    this.f = ahte.a(this.e);
  }
  
  public void a(int paramInt, View paramView)
  {
    Object localObject2 = getItem(paramInt);
    Object localObject1 = paramView.getTag();
    if (!asku.class.isInstance(localObject2))
    {
      QLog.d("ChatHistoryEmotionAdapter", 2, "[updateView] is not AIORichMediaInfo, position:" + paramInt);
      return;
    }
    if (!(localObject1 instanceof aski))
    {
      QLog.d("ChatHistoryEmotionAdapter", 2, "[updateView] is not ContentHolder, position:" + paramInt);
      return;
    }
    localObject1 = (aski)localObject1;
    localObject2 = (asku)localObject2;
    Object localObject3 = ((aski)localObject1).jdField_a_of_type_ComTencentImageURLImageView;
    Object localObject4 = this.jdField_a_of_type_Asko;
    localObject4 = asko.a(this.jdField_a_of_type_AndroidContentContext, (asku)localObject2);
    if (((asku)localObject2).jdField_b_of_type_Boolean)
    {
      if (((asku)localObject2).jdField_c_of_type_Boolean) {
        ((URLImageView)localObject3).setURLDrawableDownListener(this);
      }
    }
    else
    {
      if ((!(localObject4 instanceof awqx)) || (((awqx)localObject4).a() == null)) {
        break label341;
      }
      ((URLImageView)localObject3).setImageBitmap(askn.a(((awqx)localObject4).a(), this.jdField_c_of_type_Int, this.jdField_c_of_type_Int));
      label191:
      localObject3 = ((aski)localObject1).jdField_a_of_type_AndroidWidgetImageView;
      localObject1 = ((aski)localObject1).b;
      if (!this.jdField_a_of_type_Boolean) {
        break label374;
      }
      if (!((asku)localObject2).jdField_a_of_type_Boolean) {
        break label351;
      }
      ((ImageView)localObject3).setVisibility(0);
      ((ImageView)localObject1).setImageResource(2130845673);
      ((ImageView)localObject1).setVisibility(0);
    }
    for (;;)
    {
      int i = paramInt / 4;
      paramView.setContentDescription(anvx.a(2131701108) + (i + 1) + anvx.a(2131701168) + (paramInt % 4 + 1) + anvx.a(2131701149));
      return;
      if (AbsDownloader.getFile(URLDrawableHelper.getURL((MessageForPic)((asku)localObject2).jdField_a_of_type_ComTencentMobileqqDataMessageRecord, 65537).toString()) != null) {
        break;
      }
      a((MessageForPic)((asku)localObject2).jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
      break;
      label341:
      ((URLImageView)localObject3).setImageDrawable((Drawable)localObject4);
      break label191;
      label351:
      ((ImageView)localObject3).setVisibility(4);
      ((ImageView)localObject1).setImageResource(2130845670);
      ((ImageView)localObject1).setVisibility(0);
      continue;
      label374:
      ((ImageView)localObject3).setVisibility(4);
      ((ImageView)localObject1).setVisibility(4);
    }
  }
  
  public void a(int paramInt, MessageForPic paramMessageForPic) {}
  
  public void a(MessageForPic paramMessageForPic)
  {
    askr localaskr = new askr(paramMessageForPic, this.jdField_a_of_type_AndroidOsHandler, this);
    if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramMessageForPic)) {
      this.jdField_a_of_type_JavaUtilHashMap.put(paramMessageForPic, localaskr);
    }
    Object localObject = a(paramMessageForPic);
    if (localObject != null) {
      ((BasePicDownloadProcessor)localObject).addDownCallback(localaskr);
    }
    do
    {
      return;
      localObject = azjv.a(5, 1536, 1);
      ((azke)localObject).a(paramMessageForPic, paramMessageForPic.getPicDownloadInfo());
      ((azke)localObject).a(localaskr);
      paramMessageForPic = BaseApplicationImpl.getApplication().getRuntime();
    } while ((paramMessageForPic == null) || (!(paramMessageForPic instanceof QQAppInterface)));
    azjv.a((azke)localObject, (QQAppInterface)paramMessageForPic);
  }
  
  public void a(List<MessageRecord> paramList)
  {
    this.jdField_b_of_type_JavaUtilList.addAll(paramList);
    a(false, paramList);
    a(false);
    notifyDataSetChanged();
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public void a(boolean paramBoolean, MessageForPic paramMessageForPic)
  {
    this.jdField_a_of_type_JavaUtilHashMap.remove(paramMessageForPic);
    notifyDataSetChanged();
  }
  
  public void a(boolean paramBoolean, List<MessageRecord> paramList)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_Int == 0) {
      return;
    }
    int i;
    if (paramBoolean)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_b_of_type_Int = -1;
      this.jdField_a_of_type_JavaLangString = null;
      if (this.jdField_a_of_type_JavaUtilCalendar == null)
      {
        this.jdField_a_of_type_JavaUtilCalendar = Calendar.getInstance();
        this.jdField_a_of_type_JavaUtilCalendar.setTimeInMillis(bcrg.a() * 1000L);
      }
      i = paramList.size() - 1;
    }
    for (;;)
    {
      if (i < 0) {
        break label292;
      }
      Object localObject2 = (MessageRecord)paramList.get(i);
      localObject1 = new asku((MessageRecord)localObject2);
      localObject2 = a(this.jdField_a_of_type_JavaUtilCalendar, ((MessageRecord)localObject2).time);
      if (!((String)localObject2).equals(this.jdField_a_of_type_JavaLangString))
      {
        this.jdField_a_of_type_JavaLangString = ((String)localObject2);
        if (this.jdField_b_of_type_Int != -1)
        {
          int k = this.jdField_b_of_type_Int % this.jdField_a_of_type_Int;
          if (k > 0)
          {
            j = 0;
            for (;;)
            {
              if (j < this.jdField_a_of_type_Int - k)
              {
                this.jdField_a_of_type_JavaUtilList.add(jdField_c_of_type_JavaLangObject);
                j += 1;
                continue;
                this.jdField_a_of_type_Ahtk.a(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_Int);
                break;
              }
            }
          }
        }
        this.jdField_b_of_type_Int = 0;
        this.jdField_a_of_type_JavaUtilList.add(localObject2);
        int j = 0;
        while (j < this.jdField_a_of_type_Int - 1)
        {
          this.jdField_a_of_type_JavaUtilList.add(jdField_b_of_type_JavaLangObject);
          j += 1;
        }
      }
      this.jdField_a_of_type_JavaUtilList.add(localObject1);
      this.jdField_b_of_type_Int += 1;
      i -= 1;
    }
    label292:
    Object localObject1 = this.jdField_a_of_type_Ahtk;
    if (!paramBoolean)
    {
      paramBoolean = bool;
      if (!paramList.isEmpty()) {}
    }
    else
    {
      paramBoolean = true;
    }
    ((ahtk)localObject1).a(paramBoolean, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaUtilList);
  }
  
  public boolean a()
  {
    return (this.jdField_c_of_type_Boolean) && (this.f != -1);
  }
  
  public boolean a(boolean paramBoolean)
  {
    if (paramBoolean != this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = paramBoolean;
      return true;
    }
    return false;
  }
  
  public int b()
  {
    return a() + this.jdField_a_of_type_Ahtk.a();
  }
  
  public void b()
  {
    if (!this.jdField_a_of_type_JavaUtilHashMap.isEmpty())
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        BasePicDownloadProcessor localBasePicDownloadProcessor = a((MessageForPic)localEntry.getKey());
        if (localBasePicDownloadProcessor != null) {
          localBasePicDownloadProcessor.removeDownCallBack((azjj)localEntry.getValue());
        }
      }
    }
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
    if (this.jdField_b_of_type_Boolean)
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
    if (!this.jdField_b_of_type_Boolean) {
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
    Object localObject1;
    Object localObject2;
    if (paramView == null)
    {
      localObject1 = null;
      switch (i)
      {
      default: 
        localObject2 = localObject1;
        localObject1 = paramView;
        paramView = (View)localObject2;
      }
    }
    for (;;)
    {
      a(paramInt, (View)localObject1, i, paramView);
      EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
      return localObject1;
      localObject1 = paramView.getTag();
      break;
      if (aski.class.isInstance(localObject1))
      {
        localObject2 = paramView;
        paramView = (View)localObject1;
        localObject1 = localObject2;
      }
      else
      {
        if ((QLog.isColorLevel()) && (paramView != null))
        {
          paramView = (AbsListView.LayoutParams)paramView.getLayoutParams();
          QLog.d("ChatHistoryEmotionAdapter", 2, "[getView] type 0 while convertView type " + paramView.viewType);
        }
        localObject2 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559156, null);
        ((View)localObject2).setLayoutParams(new AbsListView.LayoutParams(this.jdField_c_of_type_Int, this.jdField_c_of_type_Int));
        paramView = new aski(this);
        paramView.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)((View)localObject2).findViewById(2131372742));
        paramView.jdField_a_of_type_ComTencentImageURLImageView.setAdjustViewBounds(false);
        paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject2).findViewById(2131372746));
        paramView.b = ((ImageView)((View)localObject2).findViewById(2131372747));
        ((View)localObject2).setTag(paramView);
        paramView = (View)localObject1;
        localObject1 = localObject2;
        continue;
        if (jdField_c_of_type_JavaLangObject.equals(localObject1))
        {
          localObject2 = paramView;
          paramView = (View)localObject1;
          localObject1 = localObject2;
        }
        else
        {
          localObject2 = new View(this.jdField_a_of_type_AndroidContentContext);
          ((View)localObject2).setLayoutParams(new AbsListView.LayoutParams(this.jdField_c_of_type_Int, this.jdField_c_of_type_Int));
          ((View)localObject2).setTag(jdField_c_of_type_JavaLangObject);
          paramView = (View)localObject1;
          localObject1 = localObject2;
          continue;
          if (askk.class.isInstance(localObject1))
          {
            localObject2 = paramView;
            paramView = (View)localObject1;
            localObject1 = localObject2;
          }
          else
          {
            localObject2 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561334, null);
            paramView = new askk(this);
            paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject2).findViewById(2131378820));
            paramView.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)((View)localObject2).findViewById(2131369395));
            localObject1 = new askj(this, this.jdField_a_of_type_AndroidContentContext);
            Object localObject3 = ((View)localObject2).getLayoutParams();
            if (localObject3 != null)
            {
              ((View)localObject2).setLayoutParams(new FrameLayout.LayoutParams(((ViewGroup.LayoutParams)localObject3).width, ((ViewGroup.LayoutParams)localObject3).height));
              ((View)localObject1).setLayoutParams(new AbsListView.LayoutParams(((ViewGroup.LayoutParams)localObject3).width, ((ViewGroup.LayoutParams)localObject3).height));
            }
            ((FrameLayout)localObject1).addView((View)localObject2);
            ((View)localObject1).setTag(paramView);
            continue;
            if (jdField_b_of_type_JavaLangObject.equals(localObject1))
            {
              localObject2 = paramView;
              paramView = (View)localObject1;
              localObject1 = localObject2;
            }
            else
            {
              localObject2 = new View(this.jdField_a_of_type_AndroidContentContext);
              ((View)localObject2).setMinimumHeight(this.d);
              ((View)localObject2).setVisibility(4);
              ((View)localObject2).setTag(jdField_b_of_type_JavaLangObject);
              paramView = (View)localObject1;
              localObject1 = localObject2;
              continue;
              if (jdField_a_of_type_JavaLangObject.equals(localObject1))
              {
                localObject2 = paramView;
                paramView = (View)localObject1;
                localObject1 = localObject2;
              }
              else
              {
                localObject2 = new askj(this, this.jdField_a_of_type_AndroidContentContext);
                paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561333, null);
                localObject3 = new FrameLayout.LayoutParams(-2, -2);
                ((FrameLayout.LayoutParams)localObject3).gravity = 17;
                paramView.setLayoutParams((ViewGroup.LayoutParams)localObject3);
                ((askj)localObject2).addView(paramView);
                ((View)localObject2).setTag(jdField_a_of_type_JavaLangObject);
                paramView = (View)localObject1;
                localObject1 = localObject2;
              }
            }
          }
        }
      }
    }
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
        break label64;
      }
      i = bheg.c(localFile.getAbsolutePath());
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        label64:
        int i = 0;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ChatHistoryEmotionAdapter", 2, new Object[] { "onLoadSuccessed,orientation:", Integer.valueOf(i) });
    }
    AIOGalleryAdapter.a(paramView, paramURLDrawable, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     askg
 * JD-Core Version:    0.7.0.1
 */