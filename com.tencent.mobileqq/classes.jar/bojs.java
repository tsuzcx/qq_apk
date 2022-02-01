import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.troop.data.TroopBarPOI;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import dov.com.qq.im.capture.paster.PasterDataManager.1;
import dov.com.qq.im.capture.view.StaticStickerProviderView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.model.DoodleEmojiItem;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class bojs
  extends bohd
  implements IEventReceiver, wis<wkj>, wlq
{
  public static AtomicBoolean a;
  private Context jdField_a_of_type_AndroidContentContext;
  protected Handler a;
  private bojw jdField_a_of_type_Bojw;
  protected botp a;
  public boxk a;
  protected bpax a;
  protected bpbc a;
  protected Runnable a;
  public CopyOnWriteArrayList<bpaw> a;
  private wkg jdField_a_of_type_Wkg;
  public wlr a;
  public boolean a;
  private boolean b;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  }
  
  public bojs()
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_Wlr = null;
    this.jdField_a_of_type_JavaLangRunnable = new PasterDataManager.1(this);
    this.jdField_a_of_type_Boxk = new bojt(this);
  }
  
  private void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((paramString1 != null) && (this.jdField_a_of_type_Bpax != null) && (!paramString1.equals(this.jdField_a_of_type_Bpax.g))) {
      this.jdField_a_of_type_Bpax.g = paramString1;
    }
    if ((paramString2 != null) && (this.jdField_a_of_type_Bpbc != null) && (!paramString2.equals(this.jdField_a_of_type_Bpbc.f))) {}
    for (int i = 1;; i = 0)
    {
      if ((this.jdField_a_of_type_Bpbc != null) && (i != 0))
      {
        this.jdField_a_of_type_Bpbc.f = paramString2;
        paramString1 = this.jdField_a_of_type_Bpbc.jdField_a_of_type_JavaUtilList.iterator();
        while (paramString1.hasNext()) {
          ((bpbd)paramString1.next()).jdField_b_of_type_JavaLangString = paramString2;
        }
        if (paramBoolean) {
          this.jdField_a_of_type_Botp.a(this.jdField_a_of_type_Bpbc);
        }
      }
      if (this.jdField_a_of_type_Bpax != null)
      {
        if (i != 0)
        {
          this.jdField_a_of_type_Bpax.f = paramString2;
          paramString1 = this.jdField_a_of_type_Bpax.jdField_a_of_type_JavaUtilList.iterator();
          while (paramString1.hasNext())
          {
            bpba localbpba = (bpba)paramString1.next();
            if (localbpba.jdField_a_of_type_Boolean) {
              localbpba.l = paramString2;
            }
          }
        }
        paramString1 = this.jdField_a_of_type_Bpax.jdField_a_of_type_JavaUtilList.iterator();
        while (paramString1.hasNext())
        {
          paramString2 = (bpba)paramString1.next();
          if ((paramString2.jdField_a_of_type_Int == 7) && (!this.jdField_a_of_type_Bpax.g.equals(paramString2.i)) && (this.jdField_a_of_type_Bpax.jdField_a_of_type_JavaUtilMap != null)) {
            a(this.jdField_a_of_type_Bpax.jdField_a_of_type_JavaUtilMap, this.jdField_a_of_type_Bpax.g, paramString2);
          }
        }
        if (paramBoolean) {
          this.jdField_a_of_type_Botp.a(this.jdField_a_of_type_Bpax);
        }
      }
      return;
    }
  }
  
  private void a(Map<String, Map<String, bpay>> paramMap, String paramString, bpba parambpba)
  {
    if (parambpba.a() != null) {
      parambpba.a().c();
    }
    Map localMap = (Map)paramMap.get(parambpba.h);
    if (localMap != null)
    {
      paramMap = (bpay)localMap.get(paramString);
      if (paramMap != null) {
        break label94;
      }
      paramMap = (bpay)localMap.get("default");
    }
    label94:
    for (;;)
    {
      if (paramMap != null)
      {
        parambpba.g = paramMap.jdField_a_of_type_JavaLangString;
        parambpba.e = paramMap.jdField_b_of_type_JavaLangString;
        parambpba.f = paramMap.c;
      }
      return;
    }
  }
  
  private void a(wkj paramwkj)
  {
    if (paramwkj != null)
    {
      this.jdField_a_of_type_Bpax.c = paramwkj.jdField_a_of_type_Int;
      if (paramwkj.jdField_a_of_type_JavaLangString != null)
      {
        paramwkj = paramwkj.jdField_a_of_type_JavaLangString.split("\\|");
        if ((paramwkj != null) && (paramwkj.length == 2))
        {
          this.jdField_a_of_type_Bpax.h = paramwkj[0];
          this.jdField_a_of_type_Bpax.i = paramwkj[1];
        }
        paramwkj = this.jdField_a_of_type_Bpax.jdField_a_of_type_JavaUtilList.iterator();
        while (paramwkj.hasNext())
        {
          bpba localbpba = (bpba)paramwkj.next();
          if (localbpba.jdField_a_of_type_Int == 6)
          {
            localbpba.j = this.jdField_a_of_type_Bpax.h;
            localbpba.k = this.jdField_a_of_type_Bpax.i;
            localbpba.c = this.jdField_a_of_type_Bpax.c;
          }
        }
      }
    }
  }
  
  private void a(wlk paramwlk, boolean paramBoolean)
  {
    ykq.b("PasterDataManager", "requestPoiList");
    wll localwll = (wll)wjs.a(9);
    wlk localwlk = paramwlk;
    if (paramwlk == null) {
      localwlk = wll.a();
    }
    if (paramBoolean)
    {
      localwll.a(localwlk, null, this);
      return;
    }
    localwll.a(localwlk, this.jdField_a_of_type_Wlr, this);
  }
  
  private void a(boolean paramBoolean)
  {
    a(null, paramBoolean);
  }
  
  private void b()
  {
    Object localObject = (bowz)wjs.a(39);
    ((bowz)localObject).c();
    String str;
    if (this.jdField_a_of_type_Bpbc == null)
    {
      this.jdField_a_of_type_Bpbc = new bpbc("0");
      this.jdField_a_of_type_Bpbc.jdField_b_of_type_Boolean = true;
      str = bowz.c((bowz)localObject, "0");
      localObject = bowz.a((bowz)localObject, "0");
      if ((TextUtils.isEmpty((CharSequence)localObject)) || (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidContentContext))) {
        break label110;
      }
      this.jdField_a_of_type_Bpbc.c = ((String)localObject);
    }
    for (;;)
    {
      this.jdField_a_of_type_Bpbc.a(str);
      if (this.jdField_a_of_type_Bpax == null) {
        this.jdField_a_of_type_Bpax = new bpax("2001");
      }
      return;
      label110:
      this.jdField_a_of_type_Bpbc.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846614);
    }
  }
  
  private static void b(bpbf parambpbf, DoodleEmojiItem paramDoodleEmojiItem)
  {
    parambpbf.jdField_b_of_type_JavaLangString = paramDoodleEmojiItem.name;
    parambpbf.c = paramDoodleEmojiItem.icon;
    parambpbf.d = paramDoodleEmojiItem.download_icon;
    parambpbf.g = paramDoodleEmojiItem.getLocalEmojiFolderPath();
    parambpbf.e = paramDoodleEmojiItem.download_wording;
    parambpbf.jdField_a_of_type_Boolean = "1".equals(paramDoodleEmojiItem.random_position);
    parambpbf.a(paramDoodleEmojiItem.config);
    parambpbf.jdField_a_of_type_Int = paramDoodleEmojiItem.hide;
    parambpbf.jdField_b_of_type_Int = paramDoodleEmojiItem.mask;
  }
  
  public botp a()
  {
    return this.jdField_a_of_type_Botp;
  }
  
  public bpaw a(String paramString)
  {
    return this.jdField_a_of_type_Botp.a(paramString);
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_Bpbc != null) {
      return this.jdField_a_of_type_Bpbc.f;
    }
    return null;
  }
  
  public List<bpaw> a()
  {
    return a(false);
  }
  
  @NonNull
  public List<bpaw> a(boolean paramBoolean)
  {
    for (;;)
    {
      DoodleEmojiItem localDoodleEmojiItem;
      Object localObject3;
      try
      {
        if ((this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null) && (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() != 0)) {
          break label752;
        }
        Object localObject1 = ((bowz)wjs.a(39)).a();
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
        localObject1 = ((Collection)localObject1).iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localDoodleEmojiItem = (DoodleEmojiItem)((Iterator)localObject1).next();
        if (localDoodleEmojiItem.type == 1)
        {
          localObject3 = new bpbf(localDoodleEmojiItem.pack_id);
          b((bpbf)localObject3, localDoodleEmojiItem);
          if (("1".equals(((bpbf)localObject3).jdField_a_of_type_JavaLangString)) && (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidContentContext))) {
            ((bpbf)localObject3).jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846471);
          }
          this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(localObject3);
          continue;
        }
        if (localDoodleEmojiItem.type != 2) {
          break label398;
        }
      }
      finally {}
      this.jdField_a_of_type_Bpbc.jdField_b_of_type_JavaLangString = localDoodleEmojiItem.name;
      if ((!TextUtils.isEmpty(localDoodleEmojiItem.icon)) && (NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidContentContext))) {
        this.jdField_a_of_type_Bpbc.c = localDoodleEmojiItem.icon;
      }
      Object localObject4;
      while (localDoodleEmojiItem.mItemList != null)
      {
        this.jdField_a_of_type_Bpbc.jdField_a_of_type_JavaUtilList = localDoodleEmojiItem.mItemList;
        if (localDoodleEmojiItem.mItemList == null) {
          break;
        }
        ykq.b("PasterDataManager", "add doodle emoji location item name = " + this.jdField_a_of_type_Bpbc.f);
        localObject3 = localDoodleEmojiItem.mItemList.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (bpbd)((Iterator)localObject3).next();
          ((bpbd)localObject4).g = this.jdField_a_of_type_Bpbc.jdField_b_of_type_JavaLangString;
          ((bpbd)localObject4).jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Bpbc.f;
        }
        this.jdField_a_of_type_Bpbc.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846614);
      }
      this.jdField_a_of_type_Bpbc.jdField_a_of_type_Boolean = "1".equals(localDoodleEmojiItem.random_position);
      this.jdField_a_of_type_Bpbc.jdField_a_of_type_Int = localDoodleEmojiItem.hide;
      this.jdField_a_of_type_Bpbc.jdField_b_of_type_Int = localDoodleEmojiItem.mask;
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(this.jdField_a_of_type_Bpbc);
      continue;
      label398:
      if (localDoodleEmojiItem.type == 3)
      {
        if (this.jdField_a_of_type_Bpax == null) {
          this.jdField_a_of_type_Bpax = new bpax(localDoodleEmojiItem.pack_id);
        }
        for (;;)
        {
          this.jdField_a_of_type_Bpax.jdField_b_of_type_JavaLangString = localDoodleEmojiItem.name;
          this.jdField_a_of_type_Bpax.jdField_a_of_type_JavaUtilList = localDoodleEmojiItem.mInfoItemList;
          this.jdField_a_of_type_Bpax.a(localDoodleEmojiItem.config);
          this.jdField_a_of_type_Bpax.jdField_a_of_type_Int = localDoodleEmojiItem.hide;
          this.jdField_a_of_type_Bpax.g = "default";
          this.jdField_a_of_type_Bpax.c = -999;
          this.jdField_a_of_type_Bpax.h = "--";
          this.jdField_a_of_type_Bpax.i = "default";
          if (this.jdField_a_of_type_Bpax.jdField_a_of_type_JavaUtilList == null) {
            break;
          }
          localObject3 = this.jdField_a_of_type_Bpax.jdField_a_of_type_JavaUtilList.iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (bpba)((Iterator)localObject3).next();
            ((bpba)localObject4).m = this.jdField_a_of_type_Bpax.jdField_b_of_type_JavaLangString;
            if (bpbb.a(((bpba)localObject4).jdField_a_of_type_Int)) {
              ((bpba)localObject4).l = this.jdField_a_of_type_Bpax.f;
            }
            if ((localDoodleEmojiItem.mCityRes != null) && (((bpba)localObject4).jdField_a_of_type_Int == 7)) {
              a(localDoodleEmojiItem.mCityRes, this.jdField_a_of_type_Bpax.g, (bpba)localObject4);
            }
            if (((bpba)localObject4).jdField_a_of_type_Int == 6)
            {
              ((bpba)localObject4).c = this.jdField_a_of_type_Bpax.c;
              ((bpba)localObject4).j = this.jdField_a_of_type_Bpax.h;
              ((bpba)localObject4).k = this.jdField_a_of_type_Bpax.i;
            }
          }
          this.jdField_a_of_type_Bpax.jdField_a_of_type_JavaLangString = localDoodleEmojiItem.pack_id;
        }
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(this.jdField_a_of_type_Bpax);
        this.jdField_a_of_type_Bpax.jdField_a_of_type_JavaUtilMap = localDoodleEmojiItem.mCityRes;
      }
    }
    ykq.b("PasterDataManager", "getDoodleFacePackages, size = " + this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size());
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    label752:
    if (paramBoolean)
    {
      StaticStickerProviderView.a(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList);
      jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    }
    CopyOnWriteArrayList localCopyOnWriteArrayList = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
    return localCopyOnWriteArrayList;
  }
  
  public void a()
  {
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void a(int paramInt, wlr paramwlr, List<TroopBarPOI> paramList)
  {
    ykq.b("PasterDataManager", "onPOIListRequestResult." + paramInt);
    if ((paramInt == 0) && (paramwlr != null))
    {
      this.jdField_a_of_type_Wlr = paramwlr;
      if ((paramList != null) && (paramList.size() > 0))
      {
        paramwlr = ((TroopBarPOI)paramList.get(0)).a();
        if (QLog.isColorLevel()) {
          QLog.d("PasterDataManager", 2, "onPOIListRequestResult " + paramwlr);
        }
        String str = ShortVideoUtils.getRecentPOI(QQStoryContext.a().getCurrentAccountUin());
        Iterator localIterator = paramList.iterator();
        while (localIterator.hasNext()) {
          if (((TroopBarPOI)localIterator.next()).a().equals(str)) {
            paramwlr = str;
          }
        }
      }
    }
    for (;;)
    {
      a(((TroopBarPOI)paramList.get(0)).jdField_b_of_type_JavaLangString, paramwlr, true);
      return;
    }
  }
  
  public void a(String paramString)
  {
    a(null, paramString, false);
  }
  
  public void a(wlk paramwlk)
  {
    this.jdField_a_of_type_Wkg = ((wkg)((wit)wjs.a(20)).a(0));
    Object localObject = this.jdField_a_of_type_Wkg.a();
    if (localObject != null)
    {
      ykq.b("PasterDataManager", "get weather from cache.");
      a((wkj)localObject);
      return;
    }
    ykq.b("PasterDataManager", "get weather from net.");
    localObject = paramwlk;
    if (paramwlk == null) {
      localObject = wll.a();
    }
    this.jdField_a_of_type_Wkg.a(this);
    this.jdField_a_of_type_Wkg.b((wlk)localObject);
  }
  
  public void a(boolean paramBoolean, Activity paramActivity)
  {
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Bpax != null) && (!"default".equals(this.jdField_a_of_type_Bpax.g)) && (!"--".equals(this.jdField_a_of_type_Bpax.h))) {
      return;
    }
    new bbhq(paramActivity, new boju(this, paramBoolean)).a();
  }
  
  public void a(boolean paramBoolean, wkj paramwkj)
  {
    if (paramBoolean) {
      a(paramwkj);
    }
  }
  
  public void initIndeed()
  {
    this.jdField_a_of_type_AndroidContentContext = BaseApplicationImpl.getContext();
    this.jdField_a_of_type_Botp = new botp();
    b();
    this.jdField_a_of_type_Bojw = new bojw(this);
    wad.a().registerSubscriber(this.jdField_a_of_type_Bojw);
    if (QLog.isDevelopLevel()) {
      QLog.d("PasterDataManager", 4, "initPasterConfig");
    }
  }
  
  public boolean isValidate()
  {
    return true;
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_Bojw != null)
    {
      wad.a().unRegisterSubscriber(this.jdField_a_of_type_Bojw);
      this.jdField_a_of_type_Bojw = null;
    }
    if (this.jdField_a_of_type_Wkg != null) {
      this.jdField_a_of_type_Wkg.b(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bojs
 * JD-Core Version:    0.7.0.1
 */