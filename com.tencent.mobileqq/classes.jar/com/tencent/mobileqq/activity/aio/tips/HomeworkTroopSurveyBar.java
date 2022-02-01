package com.tencent.mobileqq.activity.aio.tips;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.TroopReportor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import tencent.im.oidb.cmd0xb36.oidb_cmd0xb36.ToastInfo;

public class HomeworkTroopSurveyBar
  implements View.OnClickListener, TipsBarTask
{
  private QQAppInterface a;
  private Activity b;
  private String c;
  private SessionInfo d;
  private TextView e;
  private ImageView f;
  private View g;
  private List<ImageView> h = new ArrayList();
  private oidb_cmd0xb36.ToastInfo i;
  
  public HomeworkTroopSurveyBar(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo, String paramString)
  {
    this.a = paramQQAppInterface;
    this.b = paramActivity;
    this.d = paramSessionInfo;
    this.c = paramString;
  }
  
  public int a()
  {
    return 59;
  }
  
  public View a(Object... paramVarArgs)
  {
    paramVarArgs = LayoutInflater.from(this.b).inflate(2131626654, null);
    this.e = ((TextView)paramVarArgs.findViewById(2131447403));
    this.f = ((ImageView)paramVarArgs.findViewById(2131435219));
    ArrayList localArrayList = new ArrayList();
    localArrayList.add((ImageView)paramVarArgs.findViewById(2131428989));
    localArrayList.add((ImageView)paramVarArgs.findViewById(2131428991));
    localArrayList.add((ImageView)paramVarArgs.findViewById(2131428993));
    this.h = localArrayList;
    paramVarArgs.setOnClickListener(this);
    this.g = paramVarArgs;
    return paramVarArgs;
  }
  
  public void a(int paramInt, Object... paramVarArgs) {}
  
  public void a(TipsManager paramTipsManager)
  {
    TroopManager localTroopManager = (TroopManager)this.a.getManager(QQManagerFactory.TROOP_MANAGER);
    localTroopManager.a(this.d.b, this.a.getCurrentAccountUin(), new HomeworkTroopSurveyBar.1(this, localTroopManager, paramTipsManager));
  }
  
  protected void a(TroopManager paramTroopManager, TipsManager paramTipsManager, TroopMemberInfo paramTroopMemberInfo)
  {
    paramTroopManager = paramTroopManager.a(this.d.b);
    if ((paramTroopManager != null) && ((paramTroopMemberInfo == null) || ((paramTroopMemberInfo.level != 332) && (paramTroopMemberInfo.level != 333))))
    {
      this.i = paramTroopManager;
      if ((paramTipsManager.a(this, new Object[0])) && (this.g != null))
      {
        if (this.i.type.has())
        {
          paramTroopManager = String.format(Locale.getDefault(), "https://pub.idqqimg.com/pc/misc/group_chain/aio_icon_%d.png", new Object[] { Integer.valueOf(this.i.type.get()) });
          paramTipsManager = URLDrawable.URLDrawableOptions.obtain();
          paramTipsManager.mRequestWidth = DisplayUtil.a(this.b, 32.0F);
          paramTipsManager.mRequestHeight = paramTipsManager.mRequestWidth;
          paramTroopManager = URLDrawable.getDrawable(paramTroopManager, paramTipsManager);
          this.f.setImageDrawable(paramTroopManager);
        }
        this.e.setText(this.i.wording.get());
        ArrayList localArrayList = new ArrayList(this.h);
        if (this.i.uins.has())
        {
          List localList = this.i.uins.get();
          int j = 0;
          while ((j < localList.size()) && (j < localArrayList.size()))
          {
            ImageView localImageView = (ImageView)localArrayList.get(j);
            localImageView.setVisibility(0);
            paramTipsManager = ImageUtil.j();
            paramTroopMemberInfo = FaceDrawable.getFaceDrawable(PlayModeUtils.b(), 1, String.valueOf(localList.get(j)), 3, paramTipsManager, paramTipsManager);
            paramTroopManager = paramTroopMemberInfo;
            if (paramTroopMemberInfo == null) {
              paramTroopManager = paramTipsManager;
            }
            localImageView.setImageDrawable(paramTroopManager);
            localArrayList.set(j, null);
            j += 1;
          }
        }
        paramTroopManager = localArrayList.iterator();
        while (paramTroopManager.hasNext())
        {
          paramTipsManager = (ImageView)paramTroopManager.next();
          if (paramTipsManager != null) {
            paramTipsManager.setVisibility(8);
          }
        }
        if (this.i.type.get() != 1) {
          paramTroopManager = "1";
        } else {
          paramTroopManager = "2";
        }
        paramTipsManager = ((TroopManager)this.a.getManager(QQManagerFactory.TROOP_MANAGER)).g(this.d.b);
        TroopReportor.a("Grp_edu", "Grp_chain", "ChainBanner_Show", 0, 0, new String[] { this.d.b, paramTroopManager, "", String.valueOf(paramTipsManager.dwGroupClassExt) });
      }
      return;
    }
    if (paramTipsManager.b() == 20) {
      paramTipsManager.c();
    }
    this.i = null;
  }
  
  public int b()
  {
    return 20;
  }
  
  public int[] c()
  {
    return null;
  }
  
  public void onClick(View paramView)
  {
    if (this.i == null)
    {
      QLog.e(".troop.survey", 1, "toast info empty , click error!");
    }
    else
    {
      Object localObject = new Intent(this.b, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", this.i.link.get());
      this.b.startActivity((Intent)localObject);
      if (this.i.type.get() != 1) {
        localObject = "1";
      } else {
        localObject = "2";
      }
      TroopInfo localTroopInfo = ((TroopManager)this.a.getManager(QQManagerFactory.TROOP_MANAGER)).g(this.d.b);
      TroopReportor.a("Grp_edu", "Grp_chain", "ChainBanner_Clk", 0, 0, new String[] { this.d.b, localObject, "", String.valueOf(localTroopInfo.dwGroupClassExt) });
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.HomeworkTroopSurveyBar
 * JD-Core Version:    0.7.0.1
 */