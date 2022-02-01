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

public class bpqh
  extends bpmq
  implements IEventReceiver, wsh<wty>, wvf
{
  public static AtomicBoolean a;
  private Context jdField_a_of_type_AndroidContentContext;
  protected Handler a;
  private bpql jdField_a_of_type_Bpql;
  protected bqfc a;
  public bqlg a;
  protected bqox a;
  protected bqpd a;
  protected Runnable a;
  public CopyOnWriteArrayList<bqow> a;
  private wtv jdField_a_of_type_Wtv;
  public wvg a;
  public boolean a;
  private boolean b;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  }
  
  public bpqh()
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_Wvg = null;
    this.jdField_a_of_type_JavaLangRunnable = new PasterDataManager.1(this);
    this.jdField_a_of_type_Bqlg = new bpqi(this);
  }
  
  private void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((paramString1 != null) && (this.jdField_a_of_type_Bqox != null) && (!paramString1.equals(this.jdField_a_of_type_Bqox.g))) {
      this.jdField_a_of_type_Bqox.g = paramString1;
    }
    if ((paramString2 != null) && (this.jdField_a_of_type_Bqpd != null) && (!paramString2.equals(this.jdField_a_of_type_Bqpd.f))) {}
    for (int i = 1;; i = 0)
    {
      if ((this.jdField_a_of_type_Bqpd != null) && (i != 0))
      {
        this.jdField_a_of_type_Bqpd.f = paramString2;
        paramString1 = this.jdField_a_of_type_Bqpd.jdField_a_of_type_JavaUtilList.iterator();
        while (paramString1.hasNext()) {
          ((bqpe)paramString1.next()).jdField_b_of_type_JavaLangString = paramString2;
        }
        if (paramBoolean) {
          this.jdField_a_of_type_Bqfc.a(this.jdField_a_of_type_Bqpd);
        }
      }
      if (this.jdField_a_of_type_Bqox != null)
      {
        if (i != 0)
        {
          this.jdField_a_of_type_Bqox.f = paramString2;
          paramString1 = this.jdField_a_of_type_Bqox.jdField_a_of_type_JavaUtilList.iterator();
          while (paramString1.hasNext())
          {
            bqpa localbqpa = (bqpa)paramString1.next();
            if (localbqpa.jdField_a_of_type_Boolean) {
              localbqpa.l = paramString2;
            }
          }
        }
        paramString1 = this.jdField_a_of_type_Bqox.jdField_a_of_type_JavaUtilList.iterator();
        while (paramString1.hasNext())
        {
          paramString2 = (bqpa)paramString1.next();
          if ((paramString2.jdField_a_of_type_Int == 7) && (!this.jdField_a_of_type_Bqox.g.equals(paramString2.i)) && (this.jdField_a_of_type_Bqox.jdField_a_of_type_JavaUtilMap != null)) {
            a(this.jdField_a_of_type_Bqox.jdField_a_of_type_JavaUtilMap, this.jdField_a_of_type_Bqox.g, paramString2);
          }
        }
        if (paramBoolean) {
          this.jdField_a_of_type_Bqfc.a(this.jdField_a_of_type_Bqox);
        }
      }
      return;
    }
  }
  
  private void a(Map<String, Map<String, bqoy>> paramMap, String paramString, bqpa parambqpa)
  {
    if (parambqpa.a() != null) {
      parambqpa.a().c();
    }
    Map localMap = (Map)paramMap.get(parambqpa.h);
    if (localMap != null)
    {
      paramMap = (bqoy)localMap.get(paramString);
      if (paramMap != null) {
        break label94;
      }
      paramMap = (bqoy)localMap.get("default");
    }
    label94:
    for (;;)
    {
      if (paramMap != null)
      {
        parambqpa.g = paramMap.jdField_a_of_type_JavaLangString;
        parambqpa.e = paramMap.jdField_b_of_type_JavaLangString;
        parambqpa.f = paramMap.c;
      }
      return;
    }
  }
  
  private void a(wty paramwty)
  {
    if (paramwty != null)
    {
      this.jdField_a_of_type_Bqox.c = paramwty.jdField_a_of_type_Int;
      if (paramwty.jdField_a_of_type_JavaLangString != null)
      {
        paramwty = paramwty.jdField_a_of_type_JavaLangString.split("\\|");
        if ((paramwty != null) && (paramwty.length == 2))
        {
          this.jdField_a_of_type_Bqox.h = paramwty[0];
          this.jdField_a_of_type_Bqox.i = paramwty[1];
        }
        paramwty = this.jdField_a_of_type_Bqox.jdField_a_of_type_JavaUtilList.iterator();
        while (paramwty.hasNext())
        {
          bqpa localbqpa = (bqpa)paramwty.next();
          if (localbqpa.jdField_a_of_type_Int == 6)
          {
            localbqpa.j = this.jdField_a_of_type_Bqox.h;
            localbqpa.k = this.jdField_a_of_type_Bqox.i;
            localbqpa.c = this.jdField_a_of_type_Bqox.c;
          }
        }
      }
    }
  }
  
  private void a(wuz paramwuz, boolean paramBoolean)
  {
    yuk.b("PasterDataManager", "requestPoiList");
    wva localwva = (wva)wth.a(9);
    wuz localwuz = paramwuz;
    if (paramwuz == null) {
      localwuz = wva.a();
    }
    if (paramBoolean)
    {
      localwva.a(localwuz, null, this);
      return;
    }
    localwva.a(localwuz, this.jdField_a_of_type_Wvg, this);
  }
  
  private void a(boolean paramBoolean)
  {
    a(null, paramBoolean);
  }
  
  private static void b(bqpg parambqpg, DoodleEmojiItem paramDoodleEmojiItem)
  {
    parambqpg.jdField_b_of_type_JavaLangString = paramDoodleEmojiItem.name;
    parambqpg.c = paramDoodleEmojiItem.icon;
    parambqpg.d = paramDoodleEmojiItem.download_icon;
    parambqpg.g = paramDoodleEmojiItem.getLocalEmojiFolderPath();
    parambqpg.e = paramDoodleEmojiItem.download_wording;
    parambqpg.jdField_a_of_type_Boolean = "1".equals(paramDoodleEmojiItem.random_position);
    parambqpg.a(paramDoodleEmojiItem.config);
    parambqpg.jdField_a_of_type_Int = paramDoodleEmojiItem.hide;
    parambqpg.jdField_b_of_type_Int = paramDoodleEmojiItem.mask;
  }
  
  private void f()
  {
    Object localObject = (bqkv)wth.a(39);
    ((bqkv)localObject).c();
    String str;
    if (this.jdField_a_of_type_Bqpd == null)
    {
      this.jdField_a_of_type_Bqpd = new bqpd("0");
      this.jdField_a_of_type_Bqpd.jdField_b_of_type_Boolean = true;
      str = bqkv.c((bqkv)localObject, "0");
      localObject = bqkv.a((bqkv)localObject, "0");
      if ((TextUtils.isEmpty((CharSequence)localObject)) || (!bhnv.g(this.jdField_a_of_type_AndroidContentContext))) {
        break label113;
      }
      this.jdField_a_of_type_Bqpd.c = ((String)localObject);
    }
    for (;;)
    {
      this.jdField_a_of_type_Bqpd.a(str);
      if (this.jdField_a_of_type_Bqox == null) {
        this.jdField_a_of_type_Bqox = new bqox("2001");
      }
      return;
      label113:
      this.jdField_a_of_type_Bqpd.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846610);
    }
  }
  
  public bqfc a()
  {
    return this.jdField_a_of_type_Bqfc;
  }
  
  public bqow a(String paramString)
  {
    return this.jdField_a_of_type_Bqfc.a(paramString);
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_Bqpd != null) {
      return this.jdField_a_of_type_Bqpd.f;
    }
    return null;
  }
  
  public List<bqow> a()
  {
    return a(false);
  }
  
  @NonNull
  public List<bqow> a(boolean paramBoolean)
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
        Object localObject1 = ((bqkv)wth.a(39)).a();
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
        localObject1 = ((Collection)localObject1).iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localDoodleEmojiItem = (DoodleEmojiItem)((Iterator)localObject1).next();
        if (localDoodleEmojiItem.type == 1)
        {
          localObject3 = new bqpg(localDoodleEmojiItem.pack_id);
          b((bqpg)localObject3, localDoodleEmojiItem);
          if (("1".equals(((bqpg)localObject3).jdField_a_of_type_JavaLangString)) && (!bhnv.g(this.jdField_a_of_type_AndroidContentContext))) {
            ((bqpg)localObject3).jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846467);
          }
          this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(localObject3);
          continue;
        }
        if (localDoodleEmojiItem.type != 2) {
          break label398;
        }
      }
      finally {}
      this.jdField_a_of_type_Bqpd.jdField_b_of_type_JavaLangString = localDoodleEmojiItem.name;
      if ((!TextUtils.isEmpty(localDoodleEmojiItem.icon)) && (bhnv.g(this.jdField_a_of_type_AndroidContentContext))) {
        this.jdField_a_of_type_Bqpd.c = localDoodleEmojiItem.icon;
      }
      Object localObject4;
      while (localDoodleEmojiItem.mItemList != null)
      {
        this.jdField_a_of_type_Bqpd.jdField_a_of_type_JavaUtilList = localDoodleEmojiItem.mItemList;
        if (localDoodleEmojiItem.mItemList == null) {
          break;
        }
        yuk.b("PasterDataManager", "add doodle emoji location item name = " + this.jdField_a_of_type_Bqpd.f);
        localObject3 = localDoodleEmojiItem.mItemList.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (bqpe)((Iterator)localObject3).next();
          ((bqpe)localObject4).g = this.jdField_a_of_type_Bqpd.jdField_b_of_type_JavaLangString;
          ((bqpe)localObject4).jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Bqpd.f;
        }
        this.jdField_a_of_type_Bqpd.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846610);
      }
      this.jdField_a_of_type_Bqpd.jdField_a_of_type_Boolean = "1".equals(localDoodleEmojiItem.random_position);
      this.jdField_a_of_type_Bqpd.jdField_a_of_type_Int = localDoodleEmojiItem.hide;
      this.jdField_a_of_type_Bqpd.jdField_b_of_type_Int = localDoodleEmojiItem.mask;
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(this.jdField_a_of_type_Bqpd);
      continue;
      label398:
      if (localDoodleEmojiItem.type == 3)
      {
        if (this.jdField_a_of_type_Bqox == null) {
          this.jdField_a_of_type_Bqox = new bqox(localDoodleEmojiItem.pack_id);
        }
        for (;;)
        {
          this.jdField_a_of_type_Bqox.jdField_b_of_type_JavaLangString = localDoodleEmojiItem.name;
          this.jdField_a_of_type_Bqox.jdField_a_of_type_JavaUtilList = localDoodleEmojiItem.mInfoItemList;
          this.jdField_a_of_type_Bqox.a(localDoodleEmojiItem.config);
          this.jdField_a_of_type_Bqox.jdField_a_of_type_Int = localDoodleEmojiItem.hide;
          this.jdField_a_of_type_Bqox.g = "default";
          this.jdField_a_of_type_Bqox.c = -999;
          this.jdField_a_of_type_Bqox.h = "--";
          this.jdField_a_of_type_Bqox.i = "default";
          if (this.jdField_a_of_type_Bqox.jdField_a_of_type_JavaUtilList == null) {
            break;
          }
          localObject3 = this.jdField_a_of_type_Bqox.jdField_a_of_type_JavaUtilList.iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (bqpa)((Iterator)localObject3).next();
            ((bqpa)localObject4).m = this.jdField_a_of_type_Bqox.jdField_b_of_type_JavaLangString;
            if (bqpb.a(((bqpa)localObject4).jdField_a_of_type_Int)) {
              ((bqpa)localObject4).l = this.jdField_a_of_type_Bqox.f;
            }
            if ((localDoodleEmojiItem.mCityRes != null) && (((bqpa)localObject4).jdField_a_of_type_Int == 7)) {
              a(localDoodleEmojiItem.mCityRes, this.jdField_a_of_type_Bqox.g, (bqpa)localObject4);
            }
            if (((bqpa)localObject4).jdField_a_of_type_Int == 6)
            {
              ((bqpa)localObject4).c = this.jdField_a_of_type_Bqox.c;
              ((bqpa)localObject4).j = this.jdField_a_of_type_Bqox.h;
              ((bqpa)localObject4).k = this.jdField_a_of_type_Bqox.i;
            }
          }
          this.jdField_a_of_type_Bqox.jdField_a_of_type_JavaLangString = localDoodleEmojiItem.pack_id;
        }
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(this.jdField_a_of_type_Bqox);
        this.jdField_a_of_type_Bqox.jdField_a_of_type_JavaUtilMap = localDoodleEmojiItem.mCityRes;
      }
    }
    yuk.b("PasterDataManager", "getDoodleFacePackages, size = " + this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size());
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
  
  public void a(int paramInt, wvg paramwvg, List<TroopBarPOI> paramList)
  {
    yuk.b("PasterDataManager", "onPOIListRequestResult." + paramInt);
    if ((paramInt == 0) && (paramwvg != null))
    {
      this.jdField_a_of_type_Wvg = paramwvg;
      if ((paramList != null) && (paramList.size() > 0))
      {
        paramwvg = ((TroopBarPOI)paramList.get(0)).a();
        if (QLog.isColorLevel()) {
          QLog.d("PasterDataManager", 2, "onPOIListRequestResult " + paramwvg);
        }
        String str = ShortVideoUtils.c(QQStoryContext.a().getCurrentAccountUin());
        Iterator localIterator = paramList.iterator();
        while (localIterator.hasNext()) {
          if (((TroopBarPOI)localIterator.next()).a().equals(str)) {
            paramwvg = str;
          }
        }
      }
    }
    for (;;)
    {
      a(((TroopBarPOI)paramList.get(0)).jdField_b_of_type_JavaLangString, paramwvg, true);
      return;
    }
  }
  
  public void a(String paramString)
  {
    a(null, paramString, false);
  }
  
  public void a(wuz paramwuz)
  {
    this.jdField_a_of_type_Wtv = ((wtv)((wsi)wth.a(20)).a(0));
    Object localObject = this.jdField_a_of_type_Wtv.a();
    if (localObject != null)
    {
      yuk.b("PasterDataManager", "get weather from cache.");
      a((wty)localObject);
      return;
    }
    yuk.b("PasterDataManager", "get weather from net.");
    localObject = paramwuz;
    if (paramwuz == null) {
      localObject = wva.a();
    }
    this.jdField_a_of_type_Wtv.a(this);
    this.jdField_a_of_type_Wtv.b((wuz)localObject);
  }
  
  public void a(boolean paramBoolean, Activity paramActivity)
  {
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Bqox != null) && (!"default".equals(this.jdField_a_of_type_Bqox.g)) && (!"--".equals(this.jdField_a_of_type_Bqox.h))) {
      return;
    }
    new bbgn(paramActivity, new bpqj(this, paramBoolean)).a();
  }
  
  public void a(boolean paramBoolean, wty paramwty)
  {
    if (paramBoolean) {
      a(paramwty);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Bpql != null)
    {
      wjj.a().unRegisterSubscriber(this.jdField_a_of_type_Bpql);
      this.jdField_a_of_type_Bpql = null;
    }
    if (this.jdField_a_of_type_Wtv != null) {
      this.jdField_a_of_type_Wtv.b(this);
    }
  }
  
  public void c()
  {
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void d()
  {
    this.jdField_a_of_type_AndroidContentContext = BaseApplicationImpl.getContext();
    this.jdField_a_of_type_Bqfc = new bqfc();
    f();
    this.jdField_a_of_type_Bpql = new bpql(this);
    wjj.a().registerSubscriber(this.jdField_a_of_type_Bpql);
    if (QLog.isDevelopLevel()) {
      QLog.d("PasterDataManager", 4, "initPasterConfig");
    }
  }
  
  public boolean isValidate()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpqh
 * JD-Core Version:    0.7.0.1
 */