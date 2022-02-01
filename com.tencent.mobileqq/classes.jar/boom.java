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

public class boom
  extends bokv
  implements IEventReceiver, wom<wqd>, wrk
{
  public static AtomicBoolean a;
  private Context jdField_a_of_type_AndroidContentContext;
  protected Handler a;
  private booq jdField_a_of_type_Booq;
  protected bpdh a;
  public bpjl a;
  protected bpnc a;
  protected bpni a;
  protected Runnable a;
  public CopyOnWriteArrayList<bpnb> a;
  private wqa jdField_a_of_type_Wqa;
  public wrl a;
  public boolean a;
  private boolean b;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  }
  
  public boom()
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_Wrl = null;
    this.jdField_a_of_type_JavaLangRunnable = new PasterDataManager.1(this);
    this.jdField_a_of_type_Bpjl = new boon(this);
  }
  
  private void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((paramString1 != null) && (this.jdField_a_of_type_Bpnc != null) && (!paramString1.equals(this.jdField_a_of_type_Bpnc.g))) {
      this.jdField_a_of_type_Bpnc.g = paramString1;
    }
    if ((paramString2 != null) && (this.jdField_a_of_type_Bpni != null) && (!paramString2.equals(this.jdField_a_of_type_Bpni.f))) {}
    for (int i = 1;; i = 0)
    {
      if ((this.jdField_a_of_type_Bpni != null) && (i != 0))
      {
        this.jdField_a_of_type_Bpni.f = paramString2;
        paramString1 = this.jdField_a_of_type_Bpni.jdField_a_of_type_JavaUtilList.iterator();
        while (paramString1.hasNext()) {
          ((bpnj)paramString1.next()).jdField_b_of_type_JavaLangString = paramString2;
        }
        if (paramBoolean) {
          this.jdField_a_of_type_Bpdh.a(this.jdField_a_of_type_Bpni);
        }
      }
      if (this.jdField_a_of_type_Bpnc != null)
      {
        if (i != 0)
        {
          this.jdField_a_of_type_Bpnc.f = paramString2;
          paramString1 = this.jdField_a_of_type_Bpnc.jdField_a_of_type_JavaUtilList.iterator();
          while (paramString1.hasNext())
          {
            bpnf localbpnf = (bpnf)paramString1.next();
            if (localbpnf.jdField_a_of_type_Boolean) {
              localbpnf.l = paramString2;
            }
          }
        }
        paramString1 = this.jdField_a_of_type_Bpnc.jdField_a_of_type_JavaUtilList.iterator();
        while (paramString1.hasNext())
        {
          paramString2 = (bpnf)paramString1.next();
          if ((paramString2.jdField_a_of_type_Int == 7) && (!this.jdField_a_of_type_Bpnc.g.equals(paramString2.i)) && (this.jdField_a_of_type_Bpnc.jdField_a_of_type_JavaUtilMap != null)) {
            a(this.jdField_a_of_type_Bpnc.jdField_a_of_type_JavaUtilMap, this.jdField_a_of_type_Bpnc.g, paramString2);
          }
        }
        if (paramBoolean) {
          this.jdField_a_of_type_Bpdh.a(this.jdField_a_of_type_Bpnc);
        }
      }
      return;
    }
  }
  
  private void a(Map<String, Map<String, bpnd>> paramMap, String paramString, bpnf parambpnf)
  {
    if (parambpnf.a() != null) {
      parambpnf.a().c();
    }
    Map localMap = (Map)paramMap.get(parambpnf.h);
    if (localMap != null)
    {
      paramMap = (bpnd)localMap.get(paramString);
      if (paramMap != null) {
        break label94;
      }
      paramMap = (bpnd)localMap.get("default");
    }
    label94:
    for (;;)
    {
      if (paramMap != null)
      {
        parambpnf.g = paramMap.jdField_a_of_type_JavaLangString;
        parambpnf.e = paramMap.jdField_b_of_type_JavaLangString;
        parambpnf.f = paramMap.c;
      }
      return;
    }
  }
  
  private void a(wqd paramwqd)
  {
    if (paramwqd != null)
    {
      this.jdField_a_of_type_Bpnc.c = paramwqd.jdField_a_of_type_Int;
      if (paramwqd.jdField_a_of_type_JavaLangString != null)
      {
        paramwqd = paramwqd.jdField_a_of_type_JavaLangString.split("\\|");
        if ((paramwqd != null) && (paramwqd.length == 2))
        {
          this.jdField_a_of_type_Bpnc.h = paramwqd[0];
          this.jdField_a_of_type_Bpnc.i = paramwqd[1];
        }
        paramwqd = this.jdField_a_of_type_Bpnc.jdField_a_of_type_JavaUtilList.iterator();
        while (paramwqd.hasNext())
        {
          bpnf localbpnf = (bpnf)paramwqd.next();
          if (localbpnf.jdField_a_of_type_Int == 6)
          {
            localbpnf.j = this.jdField_a_of_type_Bpnc.h;
            localbpnf.k = this.jdField_a_of_type_Bpnc.i;
            localbpnf.c = this.jdField_a_of_type_Bpnc.c;
          }
        }
      }
    }
  }
  
  private void a(wre paramwre, boolean paramBoolean)
  {
    yqp.b("PasterDataManager", "requestPoiList");
    wrf localwrf = (wrf)wpm.a(9);
    wre localwre = paramwre;
    if (paramwre == null) {
      localwre = wrf.a();
    }
    if (paramBoolean)
    {
      localwrf.a(localwre, null, this);
      return;
    }
    localwrf.a(localwre, this.jdField_a_of_type_Wrl, this);
  }
  
  private void a(boolean paramBoolean)
  {
    a(null, paramBoolean);
  }
  
  private static void b(bpnl parambpnl, DoodleEmojiItem paramDoodleEmojiItem)
  {
    parambpnl.jdField_b_of_type_JavaLangString = paramDoodleEmojiItem.name;
    parambpnl.c = paramDoodleEmojiItem.icon;
    parambpnl.d = paramDoodleEmojiItem.download_icon;
    parambpnl.g = paramDoodleEmojiItem.getLocalEmojiFolderPath();
    parambpnl.e = paramDoodleEmojiItem.download_wording;
    parambpnl.jdField_a_of_type_Boolean = "1".equals(paramDoodleEmojiItem.random_position);
    parambpnl.a(paramDoodleEmojiItem.config);
    parambpnl.jdField_a_of_type_Int = paramDoodleEmojiItem.hide;
    parambpnl.jdField_b_of_type_Int = paramDoodleEmojiItem.mask;
  }
  
  private void e()
  {
    Object localObject = (bpja)wpm.a(39);
    ((bpja)localObject).c();
    String str;
    if (this.jdField_a_of_type_Bpni == null)
    {
      this.jdField_a_of_type_Bpni = new bpni("0");
      this.jdField_a_of_type_Bpni.jdField_b_of_type_Boolean = true;
      str = bpja.c((bpja)localObject, "0");
      localObject = bpja.a((bpja)localObject, "0");
      if ((TextUtils.isEmpty((CharSequence)localObject)) || (!bgnt.g(this.jdField_a_of_type_AndroidContentContext))) {
        break label113;
      }
      this.jdField_a_of_type_Bpni.c = ((String)localObject);
    }
    for (;;)
    {
      this.jdField_a_of_type_Bpni.a(str);
      if (this.jdField_a_of_type_Bpnc == null) {
        this.jdField_a_of_type_Bpnc = new bpnc("2001");
      }
      return;
      label113:
      this.jdField_a_of_type_Bpni.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846593);
    }
  }
  
  public bpdh a()
  {
    return this.jdField_a_of_type_Bpdh;
  }
  
  public bpnb a(String paramString)
  {
    return this.jdField_a_of_type_Bpdh.a(paramString);
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_Bpni != null) {
      return this.jdField_a_of_type_Bpni.f;
    }
    return null;
  }
  
  public List<bpnb> a()
  {
    return a(false);
  }
  
  @NonNull
  public List<bpnb> a(boolean paramBoolean)
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
        Object localObject1 = ((bpja)wpm.a(39)).a();
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
        localObject1 = ((Collection)localObject1).iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localDoodleEmojiItem = (DoodleEmojiItem)((Iterator)localObject1).next();
        if (localDoodleEmojiItem.type == 1)
        {
          localObject3 = new bpnl(localDoodleEmojiItem.pack_id);
          b((bpnl)localObject3, localDoodleEmojiItem);
          if (("1".equals(((bpnl)localObject3).jdField_a_of_type_JavaLangString)) && (!bgnt.g(this.jdField_a_of_type_AndroidContentContext))) {
            ((bpnl)localObject3).jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846450);
          }
          this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(localObject3);
          continue;
        }
        if (localDoodleEmojiItem.type != 2) {
          break label398;
        }
      }
      finally {}
      this.jdField_a_of_type_Bpni.jdField_b_of_type_JavaLangString = localDoodleEmojiItem.name;
      if ((!TextUtils.isEmpty(localDoodleEmojiItem.icon)) && (bgnt.g(this.jdField_a_of_type_AndroidContentContext))) {
        this.jdField_a_of_type_Bpni.c = localDoodleEmojiItem.icon;
      }
      Object localObject4;
      while (localDoodleEmojiItem.mItemList != null)
      {
        this.jdField_a_of_type_Bpni.jdField_a_of_type_JavaUtilList = localDoodleEmojiItem.mItemList;
        if (localDoodleEmojiItem.mItemList == null) {
          break;
        }
        yqp.b("PasterDataManager", "add doodle emoji location item name = " + this.jdField_a_of_type_Bpni.f);
        localObject3 = localDoodleEmojiItem.mItemList.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (bpnj)((Iterator)localObject3).next();
          ((bpnj)localObject4).g = this.jdField_a_of_type_Bpni.jdField_b_of_type_JavaLangString;
          ((bpnj)localObject4).jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Bpni.f;
        }
        this.jdField_a_of_type_Bpni.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846593);
      }
      this.jdField_a_of_type_Bpni.jdField_a_of_type_Boolean = "1".equals(localDoodleEmojiItem.random_position);
      this.jdField_a_of_type_Bpni.jdField_a_of_type_Int = localDoodleEmojiItem.hide;
      this.jdField_a_of_type_Bpni.jdField_b_of_type_Int = localDoodleEmojiItem.mask;
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(this.jdField_a_of_type_Bpni);
      continue;
      label398:
      if (localDoodleEmojiItem.type == 3)
      {
        if (this.jdField_a_of_type_Bpnc == null) {
          this.jdField_a_of_type_Bpnc = new bpnc(localDoodleEmojiItem.pack_id);
        }
        for (;;)
        {
          this.jdField_a_of_type_Bpnc.jdField_b_of_type_JavaLangString = localDoodleEmojiItem.name;
          this.jdField_a_of_type_Bpnc.jdField_a_of_type_JavaUtilList = localDoodleEmojiItem.mInfoItemList;
          this.jdField_a_of_type_Bpnc.a(localDoodleEmojiItem.config);
          this.jdField_a_of_type_Bpnc.jdField_a_of_type_Int = localDoodleEmojiItem.hide;
          this.jdField_a_of_type_Bpnc.g = "default";
          this.jdField_a_of_type_Bpnc.c = -999;
          this.jdField_a_of_type_Bpnc.h = "--";
          this.jdField_a_of_type_Bpnc.i = "default";
          if (this.jdField_a_of_type_Bpnc.jdField_a_of_type_JavaUtilList == null) {
            break;
          }
          localObject3 = this.jdField_a_of_type_Bpnc.jdField_a_of_type_JavaUtilList.iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (bpnf)((Iterator)localObject3).next();
            ((bpnf)localObject4).m = this.jdField_a_of_type_Bpnc.jdField_b_of_type_JavaLangString;
            if (bpng.a(((bpnf)localObject4).jdField_a_of_type_Int)) {
              ((bpnf)localObject4).l = this.jdField_a_of_type_Bpnc.f;
            }
            if ((localDoodleEmojiItem.mCityRes != null) && (((bpnf)localObject4).jdField_a_of_type_Int == 7)) {
              a(localDoodleEmojiItem.mCityRes, this.jdField_a_of_type_Bpnc.g, (bpnf)localObject4);
            }
            if (((bpnf)localObject4).jdField_a_of_type_Int == 6)
            {
              ((bpnf)localObject4).c = this.jdField_a_of_type_Bpnc.c;
              ((bpnf)localObject4).j = this.jdField_a_of_type_Bpnc.h;
              ((bpnf)localObject4).k = this.jdField_a_of_type_Bpnc.i;
            }
          }
          this.jdField_a_of_type_Bpnc.jdField_a_of_type_JavaLangString = localDoodleEmojiItem.pack_id;
        }
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(this.jdField_a_of_type_Bpnc);
        this.jdField_a_of_type_Bpnc.jdField_a_of_type_JavaUtilMap = localDoodleEmojiItem.mCityRes;
      }
    }
    yqp.b("PasterDataManager", "getDoodleFacePackages, size = " + this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size());
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
  
  public void a(int paramInt, wrl paramwrl, List<TroopBarPOI> paramList)
  {
    yqp.b("PasterDataManager", "onPOIListRequestResult." + paramInt);
    if ((paramInt == 0) && (paramwrl != null))
    {
      this.jdField_a_of_type_Wrl = paramwrl;
      if ((paramList != null) && (paramList.size() > 0))
      {
        paramwrl = ((TroopBarPOI)paramList.get(0)).a();
        if (QLog.isColorLevel()) {
          QLog.d("PasterDataManager", 2, "onPOIListRequestResult " + paramwrl);
        }
        String str = ShortVideoUtils.c(QQStoryContext.a().getCurrentAccountUin());
        Iterator localIterator = paramList.iterator();
        while (localIterator.hasNext()) {
          if (((TroopBarPOI)localIterator.next()).a().equals(str)) {
            paramwrl = str;
          }
        }
      }
    }
    for (;;)
    {
      a(((TroopBarPOI)paramList.get(0)).jdField_b_of_type_JavaLangString, paramwrl, true);
      return;
    }
  }
  
  public void a(String paramString)
  {
    a(null, paramString, false);
  }
  
  public void a(wre paramwre)
  {
    this.jdField_a_of_type_Wqa = ((wqa)((won)wpm.a(20)).a(0));
    Object localObject = this.jdField_a_of_type_Wqa.a();
    if (localObject != null)
    {
      yqp.b("PasterDataManager", "get weather from cache.");
      a((wqd)localObject);
      return;
    }
    yqp.b("PasterDataManager", "get weather from net.");
    localObject = paramwre;
    if (paramwre == null) {
      localObject = wrf.a();
    }
    this.jdField_a_of_type_Wqa.a(this);
    this.jdField_a_of_type_Wqa.b((wre)localObject);
  }
  
  public void a(boolean paramBoolean, Activity paramActivity)
  {
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Bpnc != null) && (!"default".equals(this.jdField_a_of_type_Bpnc.g)) && (!"--".equals(this.jdField_a_of_type_Bpnc.h))) {
      return;
    }
    new banu(paramActivity, new booo(this, paramBoolean)).a();
  }
  
  public void a(boolean paramBoolean, wqd paramwqd)
  {
    if (paramBoolean) {
      a(paramwqd);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Booq != null)
    {
      wfo.a().unRegisterSubscriber(this.jdField_a_of_type_Booq);
      this.jdField_a_of_type_Booq = null;
    }
    if (this.jdField_a_of_type_Wqa != null) {
      this.jdField_a_of_type_Wqa.b(this);
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidContentContext = BaseApplicationImpl.getContext();
    this.jdField_a_of_type_Bpdh = new bpdh();
    e();
    this.jdField_a_of_type_Booq = new booq(this);
    wfo.a().registerSubscriber(this.jdField_a_of_type_Booq);
    if (QLog.isDevelopLevel()) {
      QLog.d("PasterDataManager", 4, "initPasterConfig");
    }
  }
  
  public void d()
  {
    this.jdField_b_of_type_Boolean = false;
  }
  
  public boolean isValidate()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     boom
 * JD-Core Version:    0.7.0.1
 */