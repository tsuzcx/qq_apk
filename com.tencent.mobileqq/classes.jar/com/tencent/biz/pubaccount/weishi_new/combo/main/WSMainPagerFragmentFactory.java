package com.tencent.biz.pubaccount.weishi_new.combo.main;

import android.os.Bundle;
import com.tencent.biz.pubaccount.weishi_new.combo.IWSFragmentFactory;
import com.tencent.biz.pubaccount.weishi_new.combo.bottomnav.WSBottomBarInfo;
import com.tencent.biz.pubaccount.weishi_new.combo.home.WSComboHomeFragment;
import com.tencent.biz.pubaccount.weishi_new.combo.home.WSComboHomeFragment.Companion;
import com.tencent.biz.pubaccount.weishi_new.combo.msg.WSMsgFragment;
import com.tencent.biz.pubaccount.weishi_new.profile.WSProfileFragment;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.mobileqq.app.QBaseFragment;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/combo/main/WSMainPagerFragmentFactory;", "Lcom/tencent/biz/pubaccount/weishi_new/combo/IWSFragmentFactory;", "barInfoList", "", "Lcom/tencent/biz/pubaccount/weishi_new/combo/bottomnav/WSBottomBarInfo;", "(Ljava/util/List;)V", "comboBottomBarInfoMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "comboFragmentMap", "Lcom/tencent/mobileqq/app/QBaseFragment;", "comboFragmentOrderMap", "", "comboHomeFragment", "createComboHomeFragment", "bundle", "Landroid/os/Bundle;", "createFragmentById", "barId", "createFragments", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getFragmentIndexById", "(Ljava/lang/String;)Ljava/lang/Integer;", "getProfileBundle", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSMainPagerFragmentFactory
  implements IWSFragmentFactory
{
  private final HashMap<String, QBaseFragment> a;
  private final HashMap<String, Integer> b;
  private final HashMap<String, WSBottomBarInfo> c;
  private QBaseFragment d;
  private final List<WSBottomBarInfo> e;
  
  public WSMainPagerFragmentFactory(@NotNull List<WSBottomBarInfo> paramList)
  {
    this.e = paramList;
    this.a = new HashMap();
    this.b = new HashMap();
    this.c = new HashMap();
  }
  
  private final QBaseFragment a(String paramString, Bundle paramBundle)
  {
    switch (paramString.hashCode())
    {
    default: 
      break;
    case 194805079: 
    case -710258968: 
      if ((paramString.equals("monofeed_tab")) && ((goto 72) || (paramString.equals("waterfall_tab")))) {
        return c(paramBundle);
      }
      break;
    case -872770723: 
      if (paramString.equals("message_tab")) {
        return (QBaseFragment)new WSMsgFragment();
      }
      break;
    case -1059699070: 
      if (paramString.equals("my_tab")) {
        return (QBaseFragment)WSProfileFragment.a(b(paramBundle));
      }
      break;
    }
    return null;
  }
  
  private final Bundle b(Bundle paramBundle)
  {
    if (paramBundle == null) {
      paramBundle = new Bundle();
    }
    paramBundle.putInt("page_type", 1);
    paramBundle.putString("from", "main");
    paramBundle.putString("key_pid", WeishiUtils.n());
    return paramBundle;
  }
  
  private final QBaseFragment c(Bundle paramBundle)
  {
    if (this.d == null) {
      this.d = WSComboHomeFragment.f.a(paramBundle);
    }
    return this.d;
  }
  
  @Nullable
  public final Integer a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "barId");
    return (Integer)this.b.get(paramString);
  }
  
  @NotNull
  public ArrayList<QBaseFragment> a(@Nullable Bundle paramBundle)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.e.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      WSBottomBarInfo localWSBottomBarInfo = (WSBottomBarInfo)localIterator.next();
      QBaseFragment localQBaseFragment = a(localWSBottomBarInfo.f(), paramBundle);
      if (localQBaseFragment != null)
      {
        ((Map)this.c).put(localWSBottomBarInfo.f(), localWSBottomBarInfo);
        if (localArrayList.contains(localQBaseFragment))
        {
          ((Map)this.b).put(localWSBottomBarInfo.f(), Integer.valueOf(localArrayList.indexOf(localQBaseFragment)));
        }
        else
        {
          localArrayList.add(localQBaseFragment);
          ((Map)this.b).put(localWSBottomBarInfo.f(), Integer.valueOf(i));
          i += 1;
        }
        ((Map)this.a).put(localWSBottomBarInfo.f(), localQBaseFragment);
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.combo.main.WSMainPagerFragmentFactory
 * JD-Core Version:    0.7.0.1
 */