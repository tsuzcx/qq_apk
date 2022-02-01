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
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CustomEmotionBase;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoAllSend;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.FavoriteEmoticonInfo;
import com.tencent.mobileqq.emoticonview.ICustomEmotionInfo;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.GestureSelectGridView;
import com.tencent.widget.GridView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.mobileqq.emoticonview.EmoticonInfo;>;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class aqzb
  extends BaseAdapter
  implements Handler.Callback, View.OnClickListener, bjqw, AdapterView.OnItemClickListener
{
  float jdField_a_of_type_Float;
  int jdField_a_of_type_Int;
  private Handler jdField_a_of_type_AndroidOsHandler;
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  Button jdField_a_of_type_AndroidWidgetButton;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private aqyi jdField_a_of_type_Aqyi;
  private volatile aqzk jdField_a_of_type_Aqzk;
  IphoneTitleBarActivity jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  GestureSelectGridView jdField_a_of_type_ComTencentWidgetGestureSelectGridView;
  List<EmoticonInfo> jdField_a_of_type_JavaUtilList = null;
  private boolean jdField_a_of_type_Boolean;
  int jdField_b_of_type_Int;
  Button jdField_b_of_type_AndroidWidgetButton;
  RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  public TextView b;
  List<EmoticonInfo> jdField_b_of_type_JavaUtilList = null;
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
  
  public aqzb(QQAppInterface paramQQAppInterface, IphoneTitleBarActivity paramIphoneTitleBarActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity = paramIphoneTitleBarActivity;
    this.jdField_a_of_type_AndroidViewLayoutInflater = paramIphoneTitleBarActivity.getLayoutInflater();
    this.jdField_a_of_type_Float = paramIphoneTitleBarActivity.getApplicationContext().getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_AndroidOsHandler = new bjng(Looper.getMainLooper(), this);
    this.jdField_e_of_type_Int = AIOUtils.dp2px(88.0F, paramIphoneTitleBarActivity.getResources());
  }
  
  private List<EmoticonInfo> a(List<EmoticonInfo> paramList)
  {
    ConcurrentHashMap localConcurrentHashMap = a();
    if ((paramList != null) && (paramList.size() > 0) && (localConcurrentHashMap.size() > 0))
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        EmoticonInfo localEmoticonInfo = (EmoticonInfo)localIterator.next();
        if (localConcurrentHashMap.containsKey(Integer.valueOf(localEmoticonInfo.emoId))) {
          localEmoticonInfo.isChecked = true;
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
        EmoticonInfo localEmoticonInfo = (EmoticonInfo)localIterator.next();
        if (localEmoticonInfo.isChecked) {
          localConcurrentHashMap.put(Integer.valueOf(localEmoticonInfo.emoId), Boolean.valueOf(true));
        }
      }
    }
    return localConcurrentHashMap;
  }
  
  private void a(View paramView, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FavEmosmViewPage", 2, "onItemClick ROAMING_TYPE_PANEL");
    }
    paramView = (aqzj)paramView.getTag();
    Object localObject = paramView.jdField_a_of_type_ComTencentImageURLImageView.getDrawable();
    if ((localObject instanceof URLDrawable))
    {
      localObject = (URLDrawable)localObject;
      if ((((URLDrawable)localObject).getStatus() != 3) && (((URLDrawable)localObject).getStatus() != 2)) {
        break label97;
      }
      if (QLog.isColorLevel()) {
        QLog.d("FavEmosmViewPage", 2, "onItemClick restartDownload status = " + ((URLDrawable)localObject).getStatus());
      }
      ((URLDrawable)localObject).restartDownload();
    }
    label97:
    while (((URLDrawable)localObject).getStatus() != 1) {
      return;
    }
    AIOEmotionFragment.a(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, (EmoticonInfo)getItem(paramInt), aagn.a(paramView.jdField_a_of_type_ComTencentImageURLImageView));
  }
  
  private void a(aqzj paramaqzj)
  {
    paramaqzj.jdField_a_of_type_AndroidViewView.setVisibility(8);
    paramaqzj.jdField_b_of_type_AndroidViewView.setVisibility(0);
    paramaqzj.c.setVisibility(8);
    paramaqzj.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
    Animatable localAnimatable = (Animatable)BaseApplication.getContext().getResources().getDrawable(2130839445);
    paramaqzj.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localAnimatable);
    localAnimatable.start();
    paramaqzj.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    if (this.f == 1)
    {
      paramaqzj.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    }
    paramaqzj.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private void a(URLImageView paramURLImageView, aqzj paramaqzj)
  {
    if ((paramURLImageView.getDrawable() instanceof URLDrawable))
    {
      paramURLImageView = (URLDrawable)paramURLImageView.getDrawable();
      if (paramURLImageView.getStatus() == 0) {
        a(paramaqzj);
      }
    }
    else
    {
      return;
    }
    if ((paramURLImageView.getStatus() == 2) || (paramURLImageView.getStatus() == 3))
    {
      b(paramaqzj);
      return;
    }
    c(paramaqzj);
  }
  
  private void a(EmoticonInfo paramEmoticonInfo, String paramString, aqzj paramaqzj)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramaqzj == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("FavEmosmViewPage", 2, "updateViewStatus holder is null");
      }
    }
    do
    {
      return;
      paramaqzj.jdField_a_of_type_ComTencentImageURLImageView.setURLDrawableDownListener(null);
      if (paramString.equals("needUpload"))
      {
        a(paramaqzj);
        return;
      }
      if (paramString.equals("failed"))
      {
        b(paramaqzj);
        return;
      }
      c(paramaqzj);
    } while (!(paramEmoticonInfo.getZoomDrawable(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getBaseContext(), 0.0F, this.jdField_e_of_type_Int, this.jdField_e_of_type_Int) instanceof URLDrawable));
    paramaqzj.jdField_a_of_type_ComTencentImageURLImageView.setURLDrawableDownListener(new aqzi(this, paramEmoticonInfo, paramaqzj));
    a(paramaqzj.jdField_a_of_type_ComTencentImageURLImageView, paramaqzj);
  }
  
  private boolean a(EmoticonInfo paramEmoticonInfo)
  {
    if ((paramEmoticonInfo instanceof FavoriteEmoticonInfo))
    {
      paramEmoticonInfo = (FavoriteEmoticonInfo)paramEmoticonInfo;
      if ((TextUtils.isEmpty(paramEmoticonInfo.roamingType)) || (!paramEmoticonInfo.roamingType.equals("failed"))) {}
    }
    do
    {
      return true;
      return false;
      if (!(paramEmoticonInfo instanceof PicEmoticonInfo)) {
        break;
      }
      paramEmoticonInfo = (PicEmoticonInfo)paramEmoticonInfo;
    } while ((!TextUtils.isEmpty(paramEmoticonInfo.roamingType)) && (paramEmoticonInfo.roamingType.equals("failed")));
    return false;
    return false;
  }
  
  private void b(aqzj paramaqzj)
  {
    paramaqzj.jdField_a_of_type_AndroidViewView.setVisibility(8);
    paramaqzj.jdField_b_of_type_AndroidViewView.setVisibility(0);
    paramaqzj.c.setVisibility(0);
    paramaqzj.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    paramaqzj.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
    if (this.f == 1)
    {
      paramaqzj.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    }
    paramaqzj.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private void c(int paramInt)
  {
    if (this.f == 0) {
      this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.setTitle(this.jdField_a_of_type_Aqyi.a());
    }
    while (this.f != 1) {
      return;
    }
    String str = String.format(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getString(2131691774), new Object[] { Integer.valueOf(paramInt) });
    this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.setTitle(str);
  }
  
  private void c(aqzj paramaqzj)
  {
    paramaqzj.jdField_a_of_type_AndroidViewView.setVisibility(8);
    paramaqzj.jdField_b_of_type_AndroidViewView.setVisibility(8);
    paramaqzj.c.setVisibility(8);
    paramaqzj.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    paramaqzj.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
    if (this.f == 1)
    {
      paramaqzj.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    }
    paramaqzj.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private void d(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_b_of_type_JavaUtilList != null)
    {
      localObject1 = localObject2;
      if (paramInt < this.jdField_b_of_type_JavaUtilList.size())
      {
        localObject1 = (EmoticonInfo)this.jdField_b_of_type_JavaUtilList.get(paramInt);
        this.jdField_b_of_type_JavaUtilList.remove(paramInt);
      }
    }
    if ((this.jdField_a_of_type_JavaUtilList != null) && (localObject1 != null))
    {
      this.jdField_a_of_type_JavaUtilList.remove(localObject1);
      arbb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(Integer.valueOf(((EmoticonInfo)localObject1).emoId));
    }
  }
  
  private void i()
  {
    if (this.f == 1)
    {
      this.f = 0;
      this.jdField_a_of_type_Aqyi.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      if ((!this.jdField_a_of_type_Aqyi.b()) && (!VipUtils.b((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()))) {
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_e_of_type_AndroidWidgetTextView.setText(2131691775);
      this.jdField_e_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getString(2131691776));
      localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((EmoticonInfo)localIterator.next()).isChecked = false;
      }
      this.jdField_a_of_type_Aqyi.c();
      d();
      if (this.jdField_c_of_type_Boolean)
      {
        p();
        e();
      }
      if (this.jdField_a_of_type_Aqzk != null) {
        this.jdField_a_of_type_Aqzk.b(false);
      }
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X80057D5", 0, 0, "", "", "", "");
    }
    while (this.f != 0)
    {
      Iterator localIterator;
      return;
    }
    this.f = 1;
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setSelectMode(true);
    this.jdField_a_of_type_Aqyi.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    c(0);
    this.jdField_e_of_type_AndroidWidgetTextView.setText(2131692310);
    this.jdField_e_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getString(2131691759));
    if ((this.jdField_a_of_type_Aqyi.b()) || (VipUtils.b((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()))) {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setAlpha(0.3F);
    this.jdField_b_of_type_AndroidWidgetTextView.setAlpha(0.3F);
    this.jdField_c_of_type_AndroidWidgetTextView.setAlpha(0.3F);
    this.jdField_a_of_type_Aqyi.b();
    this.jdField_a_of_type_Aqyi.e();
    if (this.jdField_a_of_type_Aqzk != null) {
      this.jdField_a_of_type_Aqzk.b(true);
    }
    bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X80057D3", 0, 0, "", "", "", "");
  }
  
  private void j()
  {
    int i;
    if (Build.VERSION.SDK_INT >= 23) {
      if (this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
        i = 1;
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.requestPermissions(new aqzc(this), 1, new String[] { "android.permission.WRITE_EXTERNAL_STORAGE" });
        return;
        i = 0;
      }
      else
      {
        c();
        this.jdField_a_of_type_Aqyi.f();
        return;
        i = 1;
      }
    }
  }
  
  private void k()
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
      localObject1 = ((arba)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(149)).a();
      localObject4 = this.jdField_b_of_type_JavaUtilList.iterator();
      for (;;)
      {
        label95:
        if (!((Iterator)localObject4).hasNext()) {
          break label292;
        }
        EmoticonInfo localEmoticonInfo = (EmoticonInfo)((Iterator)localObject4).next();
        if (localEmoticonInfo.isChecked)
        {
          localEmoticonInfo.isChecked = false;
          if (a(localEmoticonInfo)) {
            localArrayList2.add(localEmoticonInfo);
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
            if (localCustomEmotionData.emoId != localEmoticonInfo.emoId) {
              break;
            }
            if ((i == 0) && (!TextUtils.isEmpty(localCustomEmotionData.resid))) {
              localArrayList4.add(localCustomEmotionData.resid);
            }
            localArrayList1.add(localCustomEmotionData);
            break label95;
            localArrayList3.add(localEmoticonInfo);
          }
        }
        else
        {
          label255:
          if (a(localEmoticonInfo)) {
            ((List)localObject2).add(localEmoticonInfo);
          } else {
            ((List)localObject3).add(localEmoticonInfo);
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
    Object localObject4 = (amrm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(72);
    if (localObject4 != null) {
      ((amrm)localObject4).a(localArrayList4);
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
    Object localObject2 = (arba)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(149);
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
          ((arba)localObject2).a((CustomEmotionBase)localObject1);
          localObject1 = ((CustomEmotionData)localObject1).cloneEmotionData((CustomEmotionData)localObject1);
          j += 1;
          ((CustomEmotionData)localObject1).emoId = j;
          ((arba)localObject2).c((CustomEmotionBase)localObject1);
          i -= 1;
        }
        ((arba)localObject2).a();
      }
      i = localArrayList3.size();
      j = localArrayList2.size();
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A6D3", "0X800A6D3", 0, 0, String.valueOf(i + j), "", "", "");
      return;
    }
  }
  
  private void l()
  {
    bjnw localbjnw = (bjnw)bjon.a(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, null);
    localbjnw.a(2131691761);
    localbjnw.a(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getString(2131692123), 3);
    localbjnw.c(2131690620);
    localbjnw.a(new aqzd(this, localbjnw));
    localbjnw.show();
  }
  
  private void m()
  {
    if (this.jdField_b_of_type_JavaUtilList == null) {
      return;
    }
    Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((EmoticonInfo)localIterator.next()).isChecked = false;
    }
    notifyDataSetChanged();
    d();
  }
  
  private void n()
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
  
  private void o()
  {
    int i;
    if (Build.VERSION.SDK_INT >= 23) {
      if (this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
        i = 1;
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.requestPermissions(new aqzh(this), 3, new String[] { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" });
        return;
        i = 0;
      }
      else
      {
        n();
        bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800A6D6", "0X800A6D6", 0, 0, "", "", "", "");
        return;
        i = 1;
      }
    }
  }
  
  private void p()
  {
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_c_of_type_Boolean = false;
      ((amrm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(72)).notifyUI(2, true, null);
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
    if (this.f == 0) {}
    do
    {
      do
      {
        return;
      } while (getCount() <= paramInt);
      localObject = getItem(paramInt);
    } while (!ICustomEmotionInfo.class.isInstance(localObject));
    Object localObject = (ICustomEmotionInfo)localObject;
    this.jdField_b_of_type_Boolean = ((ICustomEmotionInfo)localObject).isChecked();
    if (!this.jdField_b_of_type_Boolean) {}
    for (boolean bool = true;; bool = false)
    {
      ((ICustomEmotionInfo)localObject).setIsChecked(bool);
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.invalidateViews();
      this.jdField_a_of_type_Boolean = true;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("FavEmosmViewPage", 2, "onSelectBegin");
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
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
        if (ICustomEmotionInfo.class.isInstance(localObject)) {
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
    Object localObject = (ICustomEmotionInfo)localObject;
    if (!this.jdField_b_of_type_Boolean) {}
    for (boolean bool = true;; bool = false)
    {
      ((ICustomEmotionInfo)localObject).setIsChecked(bool);
      break;
    }
    label174:
    paramInt1 = j + 1;
    if (paramInt1 <= this.jdField_c_of_type_Int)
    {
      localObject = getItem(paramInt1);
      if (!ICustomEmotionInfo.class.isInstance(localObject)) {}
      for (;;)
      {
        paramInt1 += 1;
        break;
        ((ICustomEmotionInfo)localObject).setIsChecked(this.jdField_b_of_type_Boolean);
      }
    }
    paramInt1 = this.jdField_d_of_type_Int;
    if (paramInt1 < i)
    {
      localObject = getItem(paramInt1);
      if (!ICustomEmotionInfo.class.isInstance(localObject)) {}
      for (;;)
      {
        paramInt1 += 1;
        break;
        ((ICustomEmotionInfo)localObject).setIsChecked(this.jdField_b_of_type_Boolean);
      }
    }
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.invalidateViews();
    d();
  }
  
  public void a(aqyi paramaqyi)
  {
    this.jdField_a_of_type_Aqyi = paramaqyi;
    Resources localResources = this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getResources();
    int i = localResources.getDisplayMetrics().widthPixels;
    int j = AIOUtils.dp2px(0.0F, localResources);
    int k = AIOUtils.dp2px(4.0F, localResources);
    int m = AIOUtils.dp2px(4.0F, localResources);
    this.jdField_a_of_type_Int = ((i - j * 2 - k * 3) / 4);
    this.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
    this.jdField_e_of_type_AndroidWidgetTextView = this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.rightViewText;
    this.jdField_d_of_type_AndroidWidgetTextView = this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.leftView;
    this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_e_of_type_AndroidWidgetTextView.setText(2131691775);
    this.jdField_e_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getString(2131691776));
    this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.findViewById(2131365957));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.findViewById(2131365959));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.findViewById(2131365958));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.findViewById(2131365968));
    this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getString(2131691766));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.findViewById(2131371404));
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView = ((GestureSelectGridView)this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.findViewById(2131365966));
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setSelectMode(false);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.findViewById(2131365967));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.findViewById(2131365912));
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
    if ((paramaqyi.a(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity)) && (paramaqyi.jdField_a_of_type_Boolean))
    {
      this.jdField_e_of_type_AndroidWidgetTextView.setText(2131690768);
      if (this.jdField_d_of_type_AndroidWidgetTextView != null) {
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    }
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.findViewById(2131363823));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    if ((paramaqyi.b()) || (VipUtils.b((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()))) {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
  }
  
  public void a(aqzk paramaqzk)
  {
    this.jdField_a_of_type_Aqzk = paramaqzk;
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
        EmoticonInfo localEmoticonInfo = (EmoticonInfo)localIterator.next();
        if (((localEmoticonInfo instanceof FavoriteEmoticonInfo)) && (TextUtils.isEmpty(((FavoriteEmoticonInfo)localEmoticonInfo).path)) && (((FavoriteEmoticonInfo)localEmoticonInfo).path.equals(paramString1))) {
          ((FavoriteEmoticonInfo)localEmoticonInfo).roamingType = paramString2;
        }
      }
    }
  }
  
  public void a(List<EmoticonInfo> paramList)
  {
    if ((!this.jdField_a_of_type_Aqyi.a()) && (paramList == null)) {
      return;
    }
    Object localObject = paramList;
    if (paramList == null) {
      localObject = new ArrayList();
    }
    arbb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).h();
    if (this.f == 0) {
      if (this.jdField_a_of_type_Aqyi.a())
      {
        if (((List)localObject).size() == 0)
        {
          paramList = new EmoticonInfo();
          paramList.operateType = 1;
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
      if (((EmoticonInfo)((List)localObject).get(0)).operateType == 1) {
        break;
      }
      paramList = new EmoticonInfo();
      paramList.operateType = 1;
      ((List)localObject).add(0, paramList);
      break;
      paramList = (List<EmoticonInfo>)localObject;
      if (a()) {
        paramList = a((List)localObject);
      }
      c(paramList);
      paramList = this.jdField_a_of_type_Aqyi.a(paramList);
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
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.setTitle(paramInt);
  }
  
  public void b(List<EmoticonInfo> paramList)
  {
    if (paramList == null) {
      return;
    }
    if ((this.jdField_a_of_type_Aqyi.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_Aqyi.jdField_a_of_type_JavaUtilList.isEmpty())) {
      paramList.addAll(this.jdField_a_of_type_Aqyi.jdField_a_of_type_JavaUtilList);
    }
    Object localObject;
    if ((this.jdField_a_of_type_Aqyi.a()) && (this.f == 0))
    {
      if (paramList.size() != 0) {
        break label139;
      }
      localObject = new EmoticonInfo();
      ((EmoticonInfo)localObject).operateType = 1;
      paramList.add(0, localObject);
    }
    for (;;)
    {
      arbb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).h();
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
      if (((EmoticonInfo)paramList.get(0)).operateType != 1)
      {
        localObject = new EmoticonInfo();
        ((EmoticonInfo)localObject).operateType = 1;
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
      EmoticonInfo localEmoticonInfo = (EmoticonInfo)((Iterator)localObject).next();
      if (localEmoticonInfo.isChecked) {
        localArrayList.add(localEmoticonInfo);
      }
    }
    if (localArrayList.isEmpty())
    {
      aszk.c(2131692277);
      return;
    }
    localObject = new awcz(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity);
    this.jdField_a_of_type_Aqyi.a().a(new aqze(this, (awcz)localObject));
    this.jdField_a_of_type_Aqyi.a().a(localArrayList);
  }
  
  public void c(List<EmoticonInfo> paramList)
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
      if (!((EmoticonInfo)localIterator.next()).isChecked) {
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
      if (this.jdField_a_of_type_Aqyi.jdField_a_of_type_Boolean)
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
        c(i);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getString(2131691760));
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
  
  public void d(List<EmoticonInfo> paramList)
  {
    this.jdField_b_of_type_JavaUtilList = paramList;
    super.notifyDataSetChanged();
  }
  
  public void e()
  {
    this.jdField_a_of_type_Aqyi.a(new aqzg(this));
  }
  
  void f()
  {
    if (this.jdField_a_of_type_Aqyi != null) {
      this.jdField_a_of_type_Aqyi.h();
    }
  }
  
  public void g()
  {
    p();
    this.jdField_a_of_type_Aqzk = null;
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
    aqzj localaqzj;
    EmoticonInfo localEmoticonInfo;
    if (paramView == null)
    {
      localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559132, null);
      localView.setLayoutParams(new AbsListView.LayoutParams(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int));
      localaqzj = new aqzj(this);
      localaqzj.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localView.findViewById(2131365963));
      localaqzj.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131365965));
      localaqzj.jdField_a_of_type_AndroidViewView = localView.findViewById(2131365960);
      localaqzj.jdField_b_of_type_AndroidViewView = localView.findViewById(2131365961);
      localaqzj.c = localView.findViewById(2131365962);
      localaqzj.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131365964));
      localView.setTag(localaqzj);
      localEmoticonInfo = (EmoticonInfo)this.jdField_b_of_type_JavaUtilList.get(paramInt);
      if (localEmoticonInfo != localaqzj.jdField_a_of_type_ComTencentImageURLImageView.getTag(2131380831))
      {
        if (localEmoticonInfo.operateType != 1) {
          break label524;
        }
        localaqzj.jdField_a_of_type_ComTencentImageURLImageView.setImageResource(2130839677);
        if (AppSetting.jdField_c_of_type_Boolean) {
          localaqzj.jdField_a_of_type_ComTencentImageURLImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getString(2131691757));
        }
        label216:
        localaqzj.jdField_a_of_type_ComTencentImageURLImageView.setTag(2131380831, localEmoticonInfo);
      }
      if ((localEmoticonInfo instanceof ICustomEmotionInfo))
      {
        ICustomEmotionInfo localICustomEmotionInfo = (ICustomEmotionInfo)localEmoticonInfo;
        a(localEmoticonInfo, localICustomEmotionInfo.getRoamingType(), localaqzj);
        if (localICustomEmotionInfo.isChecked()) {
          break label559;
        }
        localaqzj.jdField_a_of_type_AndroidViewView.setVisibility(8);
        localaqzj.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845585);
        label290:
        if (this.f != 1) {
          break label582;
        }
        localaqzj.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        label307:
        if (localEmoticonInfo.operateType != 1)
        {
          paramView = this.jdField_a_of_type_Aqyi.a(localEmoticonInfo);
          if ((!AppSetting.jdField_c_of_type_Boolean) || (TextUtils.isEmpty(paramView)) || (localaqzj.jdField_a_of_type_AndroidWidgetImageView.getVisibility() != 0)) {
            break label648;
          }
          if (localICustomEmotionInfo.isChecked()) {
            break label595;
          }
          if ((!AppSetting.jdField_c_of_type_Boolean) || (TextUtils.isEmpty(paramView))) {
            break label648;
          }
          paramView = paramView + "," + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131719368);
        }
      }
    }
    label648:
    for (;;)
    {
      localaqzj.jdField_a_of_type_ComTencentImageURLImageView.setContentDescription(paramView);
      if (localEmoticonInfo.operateType == 1)
      {
        localaqzj.jdField_a_of_type_AndroidViewView.setVisibility(8);
        localaqzj.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        localaqzj.jdField_b_of_type_AndroidViewView.setVisibility(8);
        localaqzj.c.setVisibility(8);
        localaqzj.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      paramView = this.jdField_a_of_type_Aqyi.a(paramInt, localView, localaqzj, localEmoticonInfo);
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      localaqzj = (aqzj)paramView.getTag();
      localView = paramView;
      break;
      label524:
      localaqzj.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(localEmoticonInfo.getZoomDrawable(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getApplicationContext(), this.jdField_a_of_type_Float, this.jdField_e_of_type_Int, this.jdField_e_of_type_Int));
      break label216;
      label559:
      localaqzj.jdField_a_of_type_AndroidViewView.setVisibility(0);
      localaqzj.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845588);
      break label290;
      label582:
      localaqzj.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      break label307;
      label595:
      if ((AppSetting.jdField_c_of_type_Boolean) && (!TextUtils.isEmpty(paramView))) {
        paramView = paramView + "," + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131690748);
      }
    }
  }
  
  public void h()
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
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 207)
    {
      d(((Integer)paramMessage.obj).intValue());
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
      araj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, i);
      return false;
    }
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
      if (this.jdField_a_of_type_Aqyi.jdField_b_of_type_Boolean)
      {
        bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005C7A", "0X8005C7A", 0, 0, "", "", "", "");
        this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.finish();
      }
      else
      {
        i();
        continue;
        if (this.jdField_b_of_type_JavaUtilList != null)
        {
          Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
          while (localIterator.hasNext())
          {
            EmoticonInfo localEmoticonInfo = (EmoticonInfo)localIterator.next();
            if ((localEmoticonInfo instanceof ICustomEmotionInfo)) {
              localEmoticonInfo.isChecked = true;
            }
          }
          notifyDataSetChanged();
          d();
          bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X80057D6", 0, 0, "", "", "", "");
          continue;
          l();
          continue;
          bgge.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, "mvip.n.a.bqsc_edit", 3, "1450000516", "CJCLUBT", this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getString(2131718745), "");
          j();
          continue;
          k();
          d();
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getString(2131691765), 0).a();
        }
      }
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_Aqyi.a(paramAdapterView, paramView, paramInt, paramLong)) {}
    String str;
    do
    {
      do
      {
        return;
        if (this.f != 0) {
          break;
        }
        if ((this.jdField_a_of_type_Aqyi.a()) && (paramInt == 0))
        {
          paramAdapterView = this.jdField_b_of_type_JavaUtilList;
          if ((paramAdapterView != null) && (paramAdapterView.size() > 0) && (((EmoticonInfo)paramAdapterView.get(0)).operateType == 1))
          {
            o();
            return;
          }
        }
        paramAdapterView = getItem(paramInt);
      } while (!(paramAdapterView instanceof ICustomEmotionInfo));
      paramAdapterView = (ICustomEmotionInfo)paramAdapterView;
      str = paramAdapterView.getRoamingType();
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
      this.jdField_a_of_type_Aqyi.a(this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView, paramInt, paramAdapterView);
      return;
    }
    if ((!TextUtils.isEmpty(str)) && (str.equals("needDownload")))
    {
      a(paramView, paramInt);
      return;
    }
    paramAdapterView = (aqzj)paramView.getTag();
    AIOEmotionFragment.a(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, (EmoticonInfo)getItem(paramInt), aagn.a(paramAdapterView.jdField_a_of_type_ComTencentImageURLImageView));
    return;
    paramAdapterView = getItem(paramInt);
    if ((paramAdapterView instanceof EmoticonInfo))
    {
      paramAdapterView = (EmoticonInfo)paramAdapterView;
      if (paramAdapterView.isChecked) {
        break label324;
      }
    }
    label324:
    for (boolean bool = true;; bool = false)
    {
      paramAdapterView.isChecked = bool;
      a(this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView, paramInt);
      d();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqzb
 * JD-Core Version:    0.7.0.1
 */