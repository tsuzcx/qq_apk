import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CustomEmotionBase;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoAllSend;
import com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.AdapterView;
import com.tencent.widget.GestureSelectGridView;
import com.tencent.widget.GridView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lappw;>;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class apik
  extends BaseAdapter
  implements Handler.Callback, View.OnClickListener, bhqp, bhte
{
  float jdField_a_of_type_Float;
  int jdField_a_of_type_Int;
  private Handler jdField_a_of_type_AndroidOsHandler;
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  Button jdField_a_of_type_AndroidWidgetButton;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private aphr jdField_a_of_type_Aphr;
  private volatile apit jdField_a_of_type_Apit;
  IphoneTitleBarActivity jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  GestureSelectGridView jdField_a_of_type_ComTencentWidgetGestureSelectGridView;
  List<appw> jdField_a_of_type_JavaUtilList = null;
  private boolean jdField_a_of_type_Boolean;
  int jdField_b_of_type_Int;
  Button jdField_b_of_type_AndroidWidgetButton;
  RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  public TextView b;
  List<appw> jdField_b_of_type_JavaUtilList = null;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = -2147483648;
  RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  public TextView c;
  private volatile boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = 2147483647;
  TextView jdField_d_of_type_AndroidWidgetTextView;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int;
  TextView jdField_e_of_type_AndroidWidgetTextView;
  private volatile int f = 0;
  
  public apik(QQAppInterface paramQQAppInterface, IphoneTitleBarActivity paramIphoneTitleBarActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity = paramIphoneTitleBarActivity;
    this.jdField_a_of_type_AndroidViewLayoutInflater = paramIphoneTitleBarActivity.getLayoutInflater();
    this.jdField_a_of_type_Float = paramIphoneTitleBarActivity.getApplicationContext().getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_AndroidOsHandler = new bhow(Looper.getMainLooper(), this);
    this.jdField_e_of_type_Int = aekt.a(88.0F, paramIphoneTitleBarActivity.getResources());
  }
  
  private List<appw> a(List<appw> paramList)
  {
    ConcurrentHashMap localConcurrentHashMap = a();
    if ((paramList != null) && (paramList.size() > 0) && (localConcurrentHashMap.size() > 0))
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        appw localappw = (appw)localIterator.next();
        if (localConcurrentHashMap.containsKey(Integer.valueOf(localappw.g))) {
          localappw.jdField_a_of_type_Boolean = true;
        }
      }
    }
    return paramList;
  }
  
  private ConcurrentHashMap<Integer, Boolean> a()
  {
    ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
    if (this.jdField_b_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        appw localappw = (appw)localIterator.next();
        if (localappw.jdField_a_of_type_Boolean) {
          localConcurrentHashMap.put(Integer.valueOf(localappw.g), Boolean.valueOf(true));
        }
      }
    }
    return localConcurrentHashMap;
  }
  
  private void a(apis paramapis)
  {
    paramapis.jdField_a_of_type_AndroidViewView.setVisibility(8);
    paramapis.jdField_b_of_type_AndroidViewView.setVisibility(0);
    paramapis.c.setVisibility(8);
    paramapis.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
    Animatable localAnimatable = (Animatable)BaseApplication.getContext().getResources().getDrawable(2130839224);
    paramapis.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localAnimatable);
    localAnimatable.start();
    paramapis.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    if (this.f == 1)
    {
      paramapis.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    }
    paramapis.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private void a(appw paramappw, String paramString, apis paramapis)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramapis == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("FavEmosmViewPage", 2, "updateViewStatus holder is null");
      }
    }
    do
    {
      return;
      paramapis.jdField_a_of_type_ComTencentImageURLImageView.setURLDrawableDownListener(null);
      if (paramString.equals("needUpload"))
      {
        a(paramapis);
        return;
      }
      if (paramString.equals("failed"))
      {
        b(paramapis);
        return;
      }
      c(paramapis);
    } while (!(paramappw.a(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getBaseContext(), 0.0F, this.jdField_e_of_type_Int, this.jdField_e_of_type_Int) instanceof URLDrawable));
    paramapis.jdField_a_of_type_ComTencentImageURLImageView.setURLDrawableDownListener(new apir(this, paramappw, paramapis));
    a(paramapis.jdField_a_of_type_ComTencentImageURLImageView, paramapis);
  }
  
  private void a(URLImageView paramURLImageView, apis paramapis)
  {
    if ((paramURLImageView.getDrawable() instanceof URLDrawable))
    {
      paramURLImageView = (URLDrawable)paramURLImageView.getDrawable();
      if (paramURLImageView.getStatus() == 0) {
        a(paramapis);
      }
    }
    else
    {
      return;
    }
    if ((paramURLImageView.getStatus() == 2) || (paramURLImageView.getStatus() == 3))
    {
      b(paramapis);
      return;
    }
    c(paramapis);
  }
  
  private boolean a(appw paramappw)
  {
    if ((paramappw instanceof apsw))
    {
      paramappw = (apsw)paramappw;
      if ((TextUtils.isEmpty(paramappw.h)) || (!paramappw.h.equals("failed"))) {}
    }
    do
    {
      return true;
      return false;
      if (!(paramappw instanceof aptm)) {
        break;
      }
      paramappw = (aptm)paramappw;
    } while ((!TextUtils.isEmpty(paramappw.a)) && (paramappw.a.equals("failed")));
    return false;
    return false;
  }
  
  private void b(int paramInt)
  {
    if (this.f == 0) {
      this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.setTitle(this.jdField_a_of_type_Aphr.a());
    }
    while (this.f != 1) {
      return;
    }
    String str = String.format(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getString(2131692072), new Object[] { Integer.valueOf(paramInt) });
    this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.setTitle(str);
  }
  
  private void b(apis paramapis)
  {
    paramapis.jdField_a_of_type_AndroidViewView.setVisibility(8);
    paramapis.jdField_b_of_type_AndroidViewView.setVisibility(0);
    paramapis.c.setVisibility(0);
    paramapis.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    paramapis.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
    if (this.f == 1)
    {
      paramapis.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    }
    paramapis.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private void c(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_b_of_type_JavaUtilList != null)
    {
      localObject1 = localObject2;
      if (paramInt < this.jdField_b_of_type_JavaUtilList.size())
      {
        localObject1 = (appw)this.jdField_b_of_type_JavaUtilList.get(paramInt);
        this.jdField_b_of_type_JavaUtilList.remove(paramInt);
      }
    }
    if ((this.jdField_a_of_type_JavaUtilList != null) && (localObject1 != null))
    {
      this.jdField_a_of_type_JavaUtilList.remove(localObject1);
      apkf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(Integer.valueOf(((appw)localObject1).g));
    }
  }
  
  private void c(apis paramapis)
  {
    paramapis.jdField_a_of_type_AndroidViewView.setVisibility(8);
    paramapis.jdField_b_of_type_AndroidViewView.setVisibility(8);
    paramapis.c.setVisibility(8);
    paramapis.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    paramapis.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
    if (this.f == 1)
    {
      paramapis.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    }
    paramapis.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private void h()
  {
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    ArrayList localArrayList3;
    Object localObject3;
    if (this.jdField_b_of_type_JavaUtilList != null)
    {
      this.jdField_c_of_type_Boolean = true;
      localArrayList4 = new ArrayList();
      localArrayList1 = new ArrayList();
      localArrayList2 = new ArrayList();
      localObject2 = new ArrayList();
      localArrayList3 = new ArrayList();
      localObject3 = new ArrayList();
      localObject1 = ((apke)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(149)).a();
      localObject4 = this.jdField_b_of_type_JavaUtilList.iterator();
      for (;;)
      {
        label95:
        if (!((Iterator)localObject4).hasNext()) {
          break label292;
        }
        appw localappw = (appw)((Iterator)localObject4).next();
        if (localappw.jdField_a_of_type_Boolean)
        {
          localappw.jdField_a_of_type_Boolean = false;
          if (a(localappw)) {
            localArrayList2.add(localappw);
          }
          for (i = 1;; i = 0)
          {
            if (localObject1 == null) {
              break label255;
            }
            Iterator localIterator = ((List)localObject1).iterator();
            if (!localIterator.hasNext()) {
              break label95;
            }
            CustomEmotionData localCustomEmotionData = (CustomEmotionData)localIterator.next();
            if (localCustomEmotionData.emoId != localappw.g) {
              break;
            }
            if ((i == 0) && (!TextUtils.isEmpty(localCustomEmotionData.resid))) {
              localArrayList4.add(localCustomEmotionData.resid);
            }
            localArrayList1.add(localCustomEmotionData);
            break label95;
            localArrayList3.add(localappw);
          }
        }
        else
        {
          label255:
          if (a(localappw)) {
            ((List)localObject2).add(localappw);
          } else {
            ((List)localObject3).add(localappw);
          }
        }
      }
      label292:
      if ((localArrayList3.size() != 0) || (localArrayList2.size() != 0)) {
        break label328;
      }
      if (QLog.isColorLevel()) {
        QLog.d("FavEmosmViewPage", 2, "handleEmotionMove selectedList is empty!");
      }
    }
    return;
    label328:
    Object localObject4 = (alnm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(72);
    if (localObject4 != null) {
      ((alnm)localObject4).a(localArrayList4);
    }
    ArrayList localArrayList4 = new ArrayList();
    if (localArrayList2.size() > 0) {
      localArrayList4.addAll(localArrayList2);
    }
    if (((List)localObject2).size() > 0) {
      localArrayList4.addAll((Collection)localObject2);
    }
    if (localArrayList3.size() > 0) {
      localArrayList4.addAll(localArrayList3);
    }
    if (((List)localObject3).size() > 0) {
      localArrayList4.addAll((Collection)localObject3);
    }
    d(localArrayList4);
    Object localObject2 = (apke)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(149);
    int j = localArrayList1.size();
    Object localObject1 = ((List)localObject1).iterator();
    int i = 1;
    if (((Iterator)localObject1).hasNext())
    {
      localObject3 = (CustomEmotionData)((Iterator)localObject1).next();
      if (i >= ((CustomEmotionData)localObject3).emoId) {
        break label653;
      }
      i = ((CustomEmotionData)localObject3).emoId;
    }
    label653:
    for (;;)
    {
      break;
      if (j > 0)
      {
        int k = j - 1;
        j = i;
        i = k;
        while (i >= 0)
        {
          localObject1 = (CustomEmotionData)localArrayList1.get(i);
          ((apke)localObject2).a((CustomEmotionBase)localObject1);
          localObject1 = ((CustomEmotionData)localObject1).cloneEmotionData((CustomEmotionData)localObject1);
          j += 1;
          ((CustomEmotionData)localObject1).emoId = j;
          ((apke)localObject2).c((CustomEmotionBase)localObject1);
          i -= 1;
        }
        ((apke)localObject2).a();
      }
      i = localArrayList3.size();
      j = localArrayList2.size();
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A6D3", "0X800A6D3", 0, 0, String.valueOf(i + j), "", "", "");
      return;
    }
  }
  
  private void i()
  {
    bhpy localbhpy = (bhpy)bhql.a(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, null);
    localbhpy.a(2131692056);
    localbhpy.a(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getString(2131692485), 3);
    localbhpy.c(2131690648);
    localbhpy.a(new apim(this, localbhpy));
    localbhpy.show();
  }
  
  private void j()
  {
    if (this.jdField_b_of_type_JavaUtilList == null) {
      return;
    }
    Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((appw)localIterator.next()).jdField_a_of_type_Boolean = false;
    }
    notifyDataSetChanged();
    d();
  }
  
  private void k()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, NewPhotoListActivity.class);
    localIntent.putExtra("enter_from", 2);
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 1);
    localIntent.putExtra("filter_photolist_troopalbum_toolbar", false);
    localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 20);
    localIntent.putExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
    localIntent.putExtra("PhotoConst.IS_FROM_EMOTION_FAVORITE", true);
    localIntent.putExtra("peakconstant.request_code", 100015);
    this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.startActivityForResult(localIntent, 100015);
  }
  
  private void l()
  {
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_c_of_type_Boolean = false;
      ((alnm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(72)).notifyUI(2, true, null);
    }
  }
  
  public Handler a()
  {
    return this.jdField_a_of_type_AndroidOsHandler;
  }
  
  public void a()
  {
    this.jdField_d_of_type_Boolean = true;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.setTitle(paramInt);
  }
  
  public void a(aphr paramaphr)
  {
    this.jdField_a_of_type_Aphr = paramaphr;
    Resources localResources = this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getResources();
    int i = localResources.getDisplayMetrics().widthPixels;
    int j = aekt.a(0.0F, localResources);
    int k = aekt.a(4.0F, localResources);
    int m = aekt.a(4.0F, localResources);
    this.jdField_a_of_type_Int = ((i - j * 2 - k * 3) / 4);
    this.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
    this.jdField_e_of_type_AndroidWidgetTextView = this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.rightViewText;
    this.jdField_d_of_type_AndroidWidgetTextView = this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.leftView;
    this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_e_of_type_AndroidWidgetTextView.setText(2131692073);
    this.jdField_e_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getString(2131692074));
    this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.findViewById(2131365647));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.findViewById(2131365649));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.findViewById(2131365648));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.findViewById(2131365658));
    this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getString(2131692064));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.findViewById(2131370749));
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView = ((GestureSelectGridView)this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.findViewById(2131365656));
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setSelectMode(false);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.findViewById(2131365657));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.findViewById(2131365603));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setScrollBarStyle(0);
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setNumColumns(4);
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setColumnWidth(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setHorizontalSpacing(k);
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setVerticalSpacing(m);
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setPadding(j, this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getPaddingTop(), j, this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getPaddingBottom());
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setOnItemClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setOnIndexChangedListener(this);
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setMaximumVelocity((int)(2500.0F * this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getResources().getDisplayMetrics().density));
    if ((paramaphr.a(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity)) && (paramaphr.jdField_a_of_type_Boolean))
    {
      this.jdField_e_of_type_AndroidWidgetTextView.setText(2131690884);
      if (this.jdField_d_of_type_AndroidWidgetTextView != null) {
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    }
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.findViewById(2131363570));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    if ((paramaphr.b()) || (VipUtils.b((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()))) {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
  }
  
  public void a(apit paramapit)
  {
    this.jdField_a_of_type_Apit = paramapit;
  }
  
  public void a(GridView paramGridView, int paramInt)
  {
    if ((paramGridView == null) || (paramInt < 0)) {}
    int i;
    int j;
    do
    {
      return;
      i = paramGridView.getFirstVisiblePosition();
      j = paramGridView.getLastVisiblePosition();
    } while ((paramInt < i) || (paramInt > j));
    getView(paramInt, paramGridView.getChildAt(paramInt - i), paramGridView);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (this.jdField_a_of_type_JavaUtilList != null))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        appw localappw = (appw)localIterator.next();
        if (((localappw instanceof apsw)) && (TextUtils.isEmpty(((apsw)localappw).e)) && (((apsw)localappw).e.equals(paramString1))) {
          ((apsw)localappw).h = paramString2;
        }
      }
    }
  }
  
  public void a(List<appw> paramList)
  {
    if ((!this.jdField_a_of_type_Aphr.a()) && (paramList == null)) {
      return;
    }
    Object localObject = paramList;
    if (paramList == null) {
      localObject = new ArrayList();
    }
    apkf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).h();
    if (this.f == 0) {
      if (this.jdField_a_of_type_Aphr.a())
      {
        if (((List)localObject).size() == 0)
        {
          paramList = new appw();
          paramList.f = 1;
          ((List)localObject).add(0, paramList);
        }
      }
      else
      {
        c((List)localObject);
        d((List)localObject);
      }
    }
    for (;;)
    {
      d();
      return;
      if (((appw)((List)localObject).get(0)).f == 1) {
        break;
      }
      paramList = new appw();
      paramList.f = 1;
      ((List)localObject).add(0, paramList);
      break;
      paramList = (List<appw>)localObject;
      if (a()) {
        paramList = a((List)localObject);
      }
      c(paramList);
      paramList = this.jdField_a_of_type_Aphr.a(paramList);
      if (paramList != null) {
        d(paramList);
      } else if (QLog.isColorLevel()) {
        QLog.d("FavEmosmViewPage", 2, "reloadFavEmotionFinished favEmoList is null");
      }
    }
  }
  
  public boolean a()
  {
    return this.f == 1;
  }
  
  public void b()
  {
    this.jdField_d_of_type_Boolean = false;
  }
  
  public void b(List<appw> paramList)
  {
    if (paramList == null) {
      return;
    }
    if ((this.jdField_a_of_type_Aphr.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_Aphr.jdField_a_of_type_JavaUtilList.isEmpty())) {
      paramList.addAll(this.jdField_a_of_type_Aphr.jdField_a_of_type_JavaUtilList);
    }
    Object localObject;
    if ((this.jdField_a_of_type_Aphr.a()) && (this.f == 0))
    {
      if (paramList.size() != 0) {
        break label139;
      }
      localObject = new appw();
      ((appw)localObject).f = 1;
      paramList.add(0, localObject);
    }
    for (;;)
    {
      apkf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).h();
      localObject = paramList;
      if (a()) {
        localObject = a(paramList);
      }
      this.jdField_a_of_type_JavaUtilList = ((List)localObject);
      this.jdField_b_of_type_JavaUtilList = ((List)localObject);
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setAdapter(this);
      d();
      return;
      label139:
      if (((appw)paramList.get(0)).f != 1)
      {
        localObject = new appw();
        ((appw)localObject).f = 1;
        paramList.add(0, localObject);
      }
    }
  }
  
  void c()
  {
    if (this.jdField_b_of_type_JavaUtilList == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject = this.jdField_b_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      appw localappw = (appw)((Iterator)localObject).next();
      if (localappw.jdField_a_of_type_Boolean) {
        localArrayList.add(localappw);
      }
    }
    if (localArrayList.isEmpty())
    {
      armz.c(2131692636);
      return;
    }
    localObject = new aulk(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity);
    this.jdField_a_of_type_Aphr.a().a(new apin(this, (aulk)localObject));
    this.jdField_a_of_type_Aphr.a().a(localArrayList);
  }
  
  public void c(List<appw> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  void d()
  {
    if (this.jdField_b_of_type_JavaUtilList == null) {
      return;
    }
    int i;
    if (getCount() > 0)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      this.jdField_a_of_type_AndroidWidgetButton.setTextColor(Color.parseColor("#00a5e0"));
      Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
      i = 0;
      label48:
      if (!localIterator.hasNext()) {
        break label103;
      }
      if (!((appw)localIterator.next()).jdField_a_of_type_Boolean) {
        break label267;
      }
      i += 1;
    }
    label267:
    for (;;)
    {
      break label48;
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      this.jdField_a_of_type_AndroidWidgetButton.setTextColor(Color.parseColor("#cccccc"));
      break;
      label103:
      if (this.jdField_a_of_type_Aphr.jdField_a_of_type_Boolean)
      {
        if (i >= 0)
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
          return;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
        return;
      }
      if (i > 0)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
        this.jdField_b_of_type_AndroidWidgetTextView.setEnabled(true);
        this.jdField_c_of_type_AndroidWidgetTextView.setEnabled(true);
        this.jdField_a_of_type_AndroidWidgetTextView.setAlpha(1.0F);
        this.jdField_b_of_type_AndroidWidgetTextView.setAlpha(1.0F);
        this.jdField_c_of_type_AndroidWidgetTextView.setAlpha(1.0F);
      }
      for (;;)
      {
        b(i);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getString(2131692055));
        return;
        this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
        this.jdField_b_of_type_AndroidWidgetTextView.setEnabled(false);
        this.jdField_c_of_type_AndroidWidgetTextView.setEnabled(false);
        this.jdField_a_of_type_AndroidWidgetTextView.setAlpha(0.3F);
        this.jdField_b_of_type_AndroidWidgetTextView.setAlpha(0.3F);
        this.jdField_c_of_type_AndroidWidgetTextView.setAlpha(0.3F);
      }
    }
  }
  
  public void d(List<appw> paramList)
  {
    this.jdField_b_of_type_JavaUtilList = paramList;
    super.notifyDataSetChanged();
  }
  
  public void e()
  {
    this.jdField_a_of_type_Aphr.a(new apip(this));
  }
  
  void f()
  {
    if (this.jdField_a_of_type_Aphr != null) {
      this.jdField_a_of_type_Aphr.h();
    }
  }
  
  public void g()
  {
    l();
    this.jdField_a_of_type_Apit = null;
  }
  
  public int getCount()
  {
    if (this.jdField_b_of_type_JavaUtilList != null) {
      return this.jdField_b_of_type_JavaUtilList.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_b_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    appw localappw;
    if (paramView == null)
    {
      localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559059, null);
      localView.setLayoutParams(new AbsListView.LayoutParams(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int));
      paramViewGroup = new apis(this);
      paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localView.findViewById(2131365653));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131365655));
      paramViewGroup.jdField_a_of_type_AndroidViewView = localView.findViewById(2131365650);
      paramViewGroup.jdField_b_of_type_AndroidViewView = localView.findViewById(2131365651);
      paramViewGroup.c = localView.findViewById(2131365652);
      paramViewGroup.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131365654));
      localView.setTag(paramViewGroup);
      localappw = (appw)this.jdField_b_of_type_JavaUtilList.get(paramInt);
      if (localappw != paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.getTag(2131379913))
      {
        if (localappw.f != 1) {
          break label483;
        }
        paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setImageResource(2130839456);
        if (AppSetting.jdField_c_of_type_Boolean) {
          paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getString(2131692052));
        }
        label205:
        paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setTag(2131379913, localappw);
      }
      if ((localappw instanceof aptd))
      {
        aptd localaptd = (aptd)localappw;
        a(localappw, localaptd.a(), paramViewGroup);
        if (localaptd.a()) {
          break label517;
        }
        paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845223);
        label275:
        if (this.f != 1) {
          break label538;
        }
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        label291:
        if (localappw.f != 1)
        {
          paramView = this.jdField_a_of_type_Aphr.a(localappw);
          if ((!AppSetting.jdField_c_of_type_Boolean) || (TextUtils.isEmpty(paramView)) || (paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.getVisibility() != 0)) {
            break label603;
          }
          if (localaptd.a()) {
            break label550;
          }
          if ((!AppSetting.jdField_c_of_type_Boolean) || (TextUtils.isEmpty(paramView))) {
            break label603;
          }
          paramView = paramView + "," + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131721188);
        }
      }
    }
    label517:
    label538:
    label550:
    label603:
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setContentDescription(paramView);
      if (localappw.f == 1)
      {
        paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        paramViewGroup.jdField_b_of_type_AndroidViewView.setVisibility(8);
        paramViewGroup.c.setVisibility(8);
        paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      return this.jdField_a_of_type_Aphr.a(paramInt, localView, paramViewGroup, localappw);
      paramViewGroup = (apis)paramView.getTag();
      localView = paramView;
      break;
      label483:
      paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(localappw.a(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getApplicationContext(), this.jdField_a_of_type_Float, this.jdField_e_of_type_Int, this.jdField_e_of_type_Int));
      break label205;
      paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(0);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845226);
      break label275;
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      break label291;
      if ((AppSetting.jdField_c_of_type_Boolean) && (!TextUtils.isEmpty(paramView))) {
        paramView = paramView + "," + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131690851);
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 207)
    {
      c(((Integer)paramMessage.obj).intValue());
      notifyDataSetChanged();
      d();
      f();
    }
    do
    {
      do
      {
        return false;
        if (paramMessage.what == 206)
        {
          a((List)paramMessage.obj);
          return false;
        }
      } while ((paramMessage.what != 208) || (!(paramMessage.obj instanceof Integer)));
      paramMessage = (Integer)paramMessage.obj;
      switch (paramMessage.intValue())
      {
      default: 
        return false;
      }
      QLog.e("FavEmosmViewPage", 1, new Object[] { "update ui, over limit flag:", Boolean.valueOf(CameraEmoAllSend.jdField_b_of_type_Boolean), " ret:", paramMessage, " onResumed:", Boolean.valueOf(this.jdField_d_of_type_Boolean) });
    } while ((CameraEmoAllSend.jdField_b_of_type_Boolean) || (!this.jdField_d_of_type_Boolean));
    CameraEmoAllSend.jdField_b_of_type_Boolean = true;
    if (paramMessage.intValue() == 7) {}
    for (int i = 1;; i = 2)
    {
      apjn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, i);
      return false;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131368644: 
    case 2131365649: 
      do
      {
        do
        {
          return;
          if (this.jdField_a_of_type_Aphr.jdField_b_of_type_Boolean)
          {
            azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005C7A", "0X8005C7A", 0, 0, "", "", "", "");
            this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.finish();
            return;
          }
          if (this.f == 1)
          {
            this.f = 0;
            this.jdField_a_of_type_Aphr.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
            if ((!this.jdField_a_of_type_Aphr.b()) && (!VipUtils.b((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()))) {
              this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
            }
            this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
            this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
            this.jdField_e_of_type_AndroidWidgetTextView.setText(2131692073);
            this.jdField_e_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getString(2131692074));
            paramView = this.jdField_b_of_type_JavaUtilList.iterator();
            while (paramView.hasNext()) {
              ((appw)paramView.next()).jdField_a_of_type_Boolean = false;
            }
            this.jdField_a_of_type_Aphr.c();
            d();
            if (this.jdField_c_of_type_Boolean)
            {
              l();
              e();
            }
            if (this.jdField_a_of_type_Apit != null) {
              this.jdField_a_of_type_Apit.b(false);
            }
            azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X80057D5", 0, 0, "", "", "", "");
            return;
          }
        } while (this.f != 0);
        this.f = 1;
        this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setSelectMode(true);
        this.jdField_a_of_type_Aphr.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        b(0);
        this.jdField_e_of_type_AndroidWidgetTextView.setText(2131692680);
        this.jdField_e_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getString(2131692054));
        if ((this.jdField_a_of_type_Aphr.b()) || (VipUtils.b((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()))) {
          this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setAlpha(0.3F);
        this.jdField_b_of_type_AndroidWidgetTextView.setAlpha(0.3F);
        this.jdField_c_of_type_AndroidWidgetTextView.setAlpha(0.3F);
        this.jdField_a_of_type_Aphr.b();
        this.jdField_a_of_type_Aphr.e();
        if (this.jdField_a_of_type_Apit != null) {
          this.jdField_a_of_type_Apit.b(true);
        }
        azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X80057D3", 0, 0, "", "", "", "");
        return;
      } while (this.jdField_b_of_type_JavaUtilList == null);
      paramView = this.jdField_b_of_type_JavaUtilList.iterator();
      while (paramView.hasNext())
      {
        appw localappw = (appw)paramView.next();
        if ((localappw instanceof aptd)) {
          localappw.jdField_a_of_type_Boolean = true;
        }
      }
      notifyDataSetChanged();
      d();
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X80057D6", 0, 0, "", "", "", "");
      return;
    case 2131365648: 
      i();
      return;
    case 2131363570: 
      bdqe.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, "mvip.n.a.bqsc_edit", 3, "1450000516", "CJCLUBT", this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getString(2131720510), "");
    case 2131365658: 
      int i = 1;
      if (Build.VERSION.SDK_INT >= 23) {
        if (this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
          break label730;
        }
      }
      label730:
      for (i = 1; i == 0; i = 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.requestPermissions(new apil(this), 1, new String[] { "android.permission.WRITE_EXTERNAL_STORAGE" });
        return;
      }
      c();
      this.jdField_a_of_type_Aphr.f();
      return;
    }
    h();
    d();
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getString(2131692061), 0).a();
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_Aphr.a(paramAdapterView, paramView, paramInt, paramLong)) {}
    label134:
    do
    {
      do
      {
        String str;
        do
        {
          do
          {
            return;
            if (this.f != 0) {
              break;
            }
            if ((this.jdField_a_of_type_Aphr.a()) && (paramInt == 0))
            {
              paramAdapterView = this.jdField_b_of_type_JavaUtilList;
              if ((paramAdapterView != null) && (paramAdapterView.size() > 0) && (((appw)paramAdapterView.get(0)).f == 1))
              {
                paramInt = 1;
                if (Build.VERSION.SDK_INT >= 23) {
                  if (this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
                    break label134;
                  }
                }
                for (paramInt = 1; paramInt == 0; paramInt = 0)
                {
                  this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.requestPermissions(new apiq(this), 3, new String[] { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" });
                  return;
                }
                k();
                azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800A6D6", "0X800A6D6", 0, 0, "", "", "", "");
                return;
              }
            }
            paramAdapterView = getItem(paramInt);
          } while (!(paramAdapterView instanceof aptd));
          paramAdapterView = (aptd)paramAdapterView;
          str = paramAdapterView.a();
          if (QLog.isColorLevel()) {
            QLog.d("FavEmosmViewPage", 2, "onItemClick roamingType = " + str);
          }
          if ((TextUtils.isEmpty(str)) || (!str.equals("needUpload"))) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("FavEmosmViewPage", 2, "onItemClick ROAMING_TYPE_NEED_UPLOAD");
        return;
        if ((!TextUtils.isEmpty(str)) && (str.equals("failed")))
        {
          if (QLog.isColorLevel()) {
            QLog.d("FavEmosmViewPage", 2, "onItemClick ROAMING_TYPE_FAILED");
          }
          this.jdField_a_of_type_Aphr.a(this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView, paramInt, paramAdapterView);
          return;
        }
        if ((TextUtils.isEmpty(str)) || (!str.equals("needDownload"))) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("FavEmosmViewPage", 2, "onItemClick ROAMING_TYPE_PANEL");
        }
        paramAdapterView = (apis)paramView.getTag();
        paramView = paramAdapterView.jdField_a_of_type_ComTencentImageURLImageView.getDrawable();
      } while (!(paramView instanceof URLDrawable));
      paramView = (URLDrawable)paramView;
      if ((paramView.getStatus() == 3) || (paramView.getStatus() == 2))
      {
        if (QLog.isColorLevel()) {
          QLog.d("FavEmosmViewPage", 2, "onItemClick restartDownload status = " + paramView.getStatus());
        }
        paramView.restartDownload();
        return;
      }
    } while (paramView.getStatus() != 1);
    AIOEmotionFragment.a(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, (appw)getItem(paramInt), zen.a(paramAdapterView.jdField_a_of_type_ComTencentImageURLImageView));
    return;
    paramAdapterView = (apis)paramView.getTag();
    AIOEmotionFragment.a(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, (appw)getItem(paramInt), zen.a(paramAdapterView.jdField_a_of_type_ComTencentImageURLImageView));
    return;
    paramAdapterView = getItem(paramInt);
    if ((paramAdapterView instanceof appw))
    {
      paramAdapterView = (appw)paramAdapterView;
      if (paramAdapterView.jdField_a_of_type_Boolean) {
        break label550;
      }
    }
    label550:
    for (boolean bool = true;; bool = false)
    {
      paramAdapterView.jdField_a_of_type_Boolean = bool;
      a(this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView, paramInt);
      d();
      return;
    }
  }
  
  public void onSelectBegin(int paramInt)
  {
    if (this.f == 0) {}
    do
    {
      do
      {
        return;
      } while (getCount() <= paramInt);
      localObject = getItem(paramInt);
    } while (!aptd.class.isInstance(localObject));
    Object localObject = (aptd)localObject;
    this.jdField_b_of_type_Boolean = ((aptd)localObject).a();
    if (!this.jdField_b_of_type_Boolean) {}
    for (boolean bool = true;; bool = false)
    {
      ((aptd)localObject).a(bool);
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.invalidateViews();
      this.jdField_a_of_type_Boolean = true;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("FavEmosmViewPage", 2, "onSelectBegin");
      return;
    }
  }
  
  public void onSelectChanged(int paramInt1, int paramInt2)
  {
    if (this.f == 0) {}
    while (!this.jdField_a_of_type_Boolean) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FavEmosmViewPage", 2, new Object[] { "onSelectBegin beginIndex:", Integer.valueOf(paramInt1), "  selectIndex:", Integer.valueOf(paramInt2) });
    }
    int j;
    int i;
    if (paramInt2 < paramInt1)
    {
      j = paramInt1;
      i = paramInt2;
      if (this.jdField_d_of_type_Int > paramInt2)
      {
        this.jdField_d_of_type_Int = paramInt2;
        i = paramInt2;
        j = paramInt1;
      }
    }
    for (;;)
    {
      paramInt1 = i;
      for (;;)
      {
        if (paramInt1 > j) {
          break label174;
        }
        localObject = getItem(paramInt1);
        if (aptd.class.isInstance(localObject)) {
          break;
        }
        paramInt1 += 1;
      }
      if (this.jdField_c_of_type_Int < paramInt2) {
        this.jdField_c_of_type_Int = paramInt2;
      }
      j = paramInt2;
      i = paramInt1;
    }
    Object localObject = (aptd)localObject;
    if (!this.jdField_b_of_type_Boolean) {}
    for (boolean bool = true;; bool = false)
    {
      ((aptd)localObject).a(bool);
      break;
    }
    label174:
    paramInt1 = j + 1;
    if (paramInt1 <= this.jdField_c_of_type_Int)
    {
      localObject = getItem(paramInt1);
      if (!aptd.class.isInstance(localObject)) {}
      for (;;)
      {
        paramInt1 += 1;
        break;
        ((aptd)localObject).a(this.jdField_b_of_type_Boolean);
      }
    }
    paramInt1 = this.jdField_d_of_type_Int;
    if (paramInt1 < i)
    {
      localObject = getItem(paramInt1);
      if (!aptd.class.isInstance(localObject)) {}
      for (;;)
      {
        paramInt1 += 1;
        break;
        ((aptd)localObject).a(this.jdField_b_of_type_Boolean);
      }
    }
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.invalidateViews();
    d();
  }
  
  public void onSelectEnd()
  {
    if (this.f == 0) {}
    while (!this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Int = -2147483648;
    this.jdField_d_of_type_Int = 2147483647;
    if (QLog.isColorLevel()) {
      QLog.d("FavEmosmViewPage", 2, "onSelectEnd");
    }
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apik
 * JD-Core Version:    0.7.0.1
 */