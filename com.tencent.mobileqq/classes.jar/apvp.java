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

public class apvp
  extends BaseAdapter
  implements apwb, URLDrawableDownListener
{
  public static final Object a;
  public static final Object b;
  public static final Object c;
  int jdField_a_of_type_Int = 4;
  private agfo jdField_a_of_type_Agfo = new agfo();
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private apvx jdField_a_of_type_Apvx;
  private GridView jdField_a_of_type_ComTencentWidgetGridView;
  private String jdField_a_of_type_JavaLangString;
  private Calendar jdField_a_of_type_JavaUtilCalendar;
  private HashMap<MessageForPic, apwa> jdField_a_of_type_JavaUtilHashMap = new HashMap();
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
  
  public apvp(Activity paramActivity, apvx paramapvx, Handler paramHandler, int paramInt, GridView paramGridView)
  {
    this.jdField_a_of_type_AndroidContentContext = paramActivity;
    this.jdField_a_of_type_Apvx = paramapvx;
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentWidgetGridView = paramGridView;
    this.jdField_a_of_type_AndroidViewLayoutInflater = paramActivity.getLayoutInflater();
    this.d = aekt.a(40.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
  }
  
  private bams a(MessageForPic paramMessageForPic)
  {
    boolean bool = true;
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface)))
    {
      aweu localaweu = new aweu();
      localaweu.e = paramMessageForPic.fileSizeFlag;
      if (localaweu.e == 1) {}
      for (;;)
      {
        int i = baul.a("aiothumb", bool);
        paramMessageForPic = ((QQAppInterface)localAppRuntime).a().a(batw.a(paramMessageForPic.md5, paramMessageForPic.uuid, i));
        if ((paramMessageForPic == null) || (!(paramMessageForPic instanceof bams))) {
          break;
        }
        return (bams)paramMessageForPic;
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
        } while (!apvt.class.isInstance(paramObject));
        paramObject = (apvt)paramObject;
      } while (paramObject == null);
      str = (String)getItem(paramInt1);
      paramObject.jdField_a_of_type_AndroidWidgetTextView.setText(str);
      if (AppSetting.jdField_c_of_type_Boolean)
      {
        paramInt1 /= 4;
        paramObject.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(alpo.a(2131702025) + (paramInt1 + 1) + alpo.a(2131701977) + str);
      }
    } while (!a());
    ViewGroup localViewGroup = (ViewGroup)paramObject.jdField_a_of_type_AndroidWidgetCheckBox.getParent();
    if (localViewGroup != null) {
      localViewGroup.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839211));
    }
    paramObject.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
    paramObject.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(this.jdField_a_of_type_Agfo.a(str));
    paramObject.jdField_a_of_type_AndroidWidgetCheckBox.setClickable(false);
    paramView.setOnClickListener(new apvq(this, str));
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
    if (this.jdField_a_of_type_Agfo.a(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_Int)) {
      notifyDataSetChanged();
    }
  }
  
  public void a(int paramInt)
  {
    this.e = paramInt;
    this.f = agfi.a(this.e);
  }
  
  public void a(int paramInt, View paramView)
  {
    Object localObject2 = getItem(paramInt);
    Object localObject1 = paramView.getTag();
    if (!apwd.class.isInstance(localObject2))
    {
      QLog.d("ChatHistoryEmotionAdapter", 2, "[updateView] is not AIORichMediaInfo, position:" + paramInt);
      return;
    }
    if (!(localObject1 instanceof apvr))
    {
      QLog.d("ChatHistoryEmotionAdapter", 2, "[updateView] is not ContentHolder, position:" + paramInt);
      return;
    }
    localObject1 = (apvr)localObject1;
    localObject2 = (apwd)localObject2;
    Object localObject3 = ((apvr)localObject1).jdField_a_of_type_ComTencentImageURLImageView;
    Object localObject4 = this.jdField_a_of_type_Apvx;
    localObject4 = apvx.a(this.jdField_a_of_type_AndroidContentContext, (apwd)localObject2);
    if (((apwd)localObject2).jdField_b_of_type_Boolean)
    {
      if (((apwd)localObject2).jdField_c_of_type_Boolean) {
        ((URLImageView)localObject3).setURLDrawableDownListener(this);
      }
    }
    else
    {
      if ((!(localObject4 instanceof attb)) || (((attb)localObject4).a() == null)) {
        break label341;
      }
      ((URLImageView)localObject3).setImageBitmap(apvw.a(((attb)localObject4).a(), this.jdField_c_of_type_Int, this.jdField_c_of_type_Int));
      label191:
      localObject3 = ((apvr)localObject1).jdField_a_of_type_AndroidWidgetImageView;
      localObject1 = ((apvr)localObject1).b;
      if (!this.jdField_a_of_type_Boolean) {
        break label374;
      }
      if (!((apwd)localObject2).jdField_a_of_type_Boolean) {
        break label351;
      }
      ((ImageView)localObject3).setVisibility(0);
      ((ImageView)localObject1).setImageResource(2130845226);
      ((ImageView)localObject1).setVisibility(0);
    }
    for (;;)
    {
      int i = paramInt / 4;
      paramView.setContentDescription(alpo.a(2131701983) + (i + 1) + alpo.a(2131702043) + (paramInt % 4 + 1) + alpo.a(2131702024));
      return;
      if (bame.a(baul.a((MessageForPic)((apwd)localObject2).jdField_a_of_type_ComTencentMobileqqDataMessageRecord, 65537).toString()) != null) {
        break;
      }
      a((MessageForPic)((apwd)localObject2).jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
      break;
      label341:
      ((URLImageView)localObject3).setImageDrawable((Drawable)localObject4);
      break label191;
      label351:
      ((ImageView)localObject3).setVisibility(4);
      ((ImageView)localObject1).setImageResource(2130845223);
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
    apwa localapwa = new apwa(paramMessageForPic, this.jdField_a_of_type_AndroidOsHandler, this);
    if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramMessageForPic)) {
      this.jdField_a_of_type_JavaUtilHashMap.put(paramMessageForPic, localapwa);
    }
    Object localObject = a(paramMessageForPic);
    if (localObject != null) {
      ((bams)localObject).b(localapwa);
    }
    do
    {
      return;
      localObject = awes.a(5, 1536, 1);
      ((awfc)localObject).a(paramMessageForPic, paramMessageForPic.getPicDownloadInfo());
      ((awfc)localObject).a(localapwa);
      paramMessageForPic = BaseApplicationImpl.getApplication().getRuntime();
    } while ((paramMessageForPic == null) || (!(paramMessageForPic instanceof QQAppInterface)));
    awes.a((awfc)localObject, (QQAppInterface)paramMessageForPic);
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
        this.jdField_a_of_type_JavaUtilCalendar.setTimeInMillis(ayvc.a() * 1000L);
      }
      i = paramList.size() - 1;
    }
    for (;;)
    {
      if (i < 0) {
        break label292;
      }
      Object localObject2 = (MessageRecord)paramList.get(i);
      localObject1 = new apwd((MessageRecord)localObject2);
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
                this.jdField_a_of_type_Agfo.a(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_Int);
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
    Object localObject1 = this.jdField_a_of_type_Agfo;
    if (!paramBoolean)
    {
      paramBoolean = bool;
      if (!paramList.isEmpty()) {}
    }
    else
    {
      paramBoolean = true;
    }
    ((agfo)localObject1).a(paramBoolean, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaUtilList);
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
    return a() + this.jdField_a_of_type_Agfo.a();
  }
  
  public void b()
  {
    if (!this.jdField_a_of_type_JavaUtilHashMap.isEmpty())
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        bams localbams = a((MessageForPic)localEntry.getKey());
        if (localbams != null) {
          localbams.a((aweh)localEntry.getValue());
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
    if (paramView == null)
    {
      paramViewGroup = null;
      switch (i)
      {
      }
    }
    for (;;)
    {
      a(paramInt, paramView, i, paramViewGroup);
      return paramView;
      paramViewGroup = paramView.getTag();
      break;
      if (!apvr.class.isInstance(paramViewGroup))
      {
        if ((QLog.isColorLevel()) && (paramView != null))
        {
          paramView = (AbsListView.LayoutParams)paramView.getLayoutParams();
          QLog.d("ChatHistoryEmotionAdapter", 2, "[getView] type 0 while convertView type " + paramView.jdField_a_of_type_Int);
        }
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559055, null);
        paramView.setLayoutParams(new AbsListView.LayoutParams(this.jdField_c_of_type_Int, this.jdField_c_of_type_Int));
        Object localObject1 = new apvr(this);
        ((apvr)localObject1).jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131371876));
        ((apvr)localObject1).jdField_a_of_type_ComTencentImageURLImageView.setAdjustViewBounds(false);
        ((apvr)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131371880));
        ((apvr)localObject1).b = ((ImageView)paramView.findViewById(2131371881));
        paramView.setTag(localObject1);
        continue;
        if (!jdField_c_of_type_JavaLangObject.equals(paramViewGroup))
        {
          paramView = new View(this.jdField_a_of_type_AndroidContentContext);
          paramView.setLayoutParams(new AbsListView.LayoutParams(this.jdField_c_of_type_Int, this.jdField_c_of_type_Int));
          paramView.setTag(jdField_c_of_type_JavaLangObject);
          continue;
          if (!apvt.class.isInstance(paramViewGroup))
          {
            localObject1 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561130, null);
            paramViewGroup = new apvt(this);
            paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131377711));
            paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)((View)localObject1).findViewById(2131368762));
            paramView = new apvs(this, this.jdField_a_of_type_AndroidContentContext);
            Object localObject2 = ((View)localObject1).getLayoutParams();
            if (localObject2 != null)
            {
              ((View)localObject1).setLayoutParams(new FrameLayout.LayoutParams(((ViewGroup.LayoutParams)localObject2).width, ((ViewGroup.LayoutParams)localObject2).height));
              paramView.setLayoutParams(new AbsListView.LayoutParams(((ViewGroup.LayoutParams)localObject2).width, ((ViewGroup.LayoutParams)localObject2).height));
            }
            ((FrameLayout)paramView).addView((View)localObject1);
            paramView.setTag(paramViewGroup);
            continue;
            if (!jdField_b_of_type_JavaLangObject.equals(paramViewGroup))
            {
              paramView = new View(this.jdField_a_of_type_AndroidContentContext);
              paramView.setMinimumHeight(this.d);
              paramView.setVisibility(4);
              paramView.setTag(jdField_b_of_type_JavaLangObject);
              continue;
              if (!jdField_a_of_type_JavaLangObject.equals(paramViewGroup))
              {
                paramView = new apvs(this, this.jdField_a_of_type_AndroidContentContext);
                localObject1 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561129, null);
                localObject2 = new FrameLayout.LayoutParams(-2, -2);
                ((FrameLayout.LayoutParams)localObject2).gravity = 17;
                ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
                paramView.addView((View)localObject1);
                paramView.setTag(jdField_a_of_type_JavaLangObject);
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
      i = bdda.c(localFile.getAbsolutePath());
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
 * Qualified Name:     apvp
 * JD-Core Version:    0.7.0.1
 */