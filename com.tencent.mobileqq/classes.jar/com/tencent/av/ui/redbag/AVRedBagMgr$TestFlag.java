package com.tencent.av.ui.redbag;

import android.os.Handler;
import android.view.Menu;
import android.widget.PopupMenu;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.AVActivity;
import com.tencent.mobileqq.utils.AudioHelper;
import ket;
import keu;
import kev;
import kew;
import key;
import kez;
import kfa;
import kfb;
import kfc;
import kfd;
import kfe;
import kff;
import kfg;
import kfh;
import kfi;
import kfj;
import kfk;
import kfl;

public class AVRedBagMgr$TestFlag
{
  public int a;
  public String a;
  public boolean a;
  public String b;
  public boolean b;
  public String c;
  public boolean c;
  public String d = "0";
  
  public AVRedBagMgr$TestFlag()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = "20000005011710261000100000426100";
    this.jdField_b_of_type_JavaLangString = "0b0c939c823c0fe5aa691d42aefc48fa";
    this.jdField_c_of_type_Boolean = false;
    this.jdField_c_of_type_JavaLangString = "0";
  }
  
  public void a(AVRedBagMgr paramAVRedBagMgr)
  {
    paramAVRedBagMgr.a(paramAVRedBagMgr.a(), 1);
  }
  
  public void a(AVRedBagMgr paramAVRedBagMgr, int paramInt) {}
  
  void a(AVRedBagMgr paramAVRedBagMgr, PopupMenu paramPopupMenu)
  {
    int i = 1;
    Menu localMenu = paramPopupMenu.getMenu();
    VideoAppInterface localVideoAppInterface = paramAVRedBagMgr.a();
    if (AudioHelper.a(5) == 1)
    {
      if (i != 0)
      {
        AVRedBagMgr.a(localVideoAppInterface, localMenu, "抢红包", new kff(this, paramAVRedBagMgr));
        AVRedBagMgr.a(localVideoAppInterface, localMenu, "显示debug页面", new kfg(this, localVideoAppInterface));
      }
      paramPopupMenu = AVRedBagMgr.a(localVideoAppInterface, localMenu, "新手tips相关");
      AVRedBagMgr.a(localVideoAppInterface, paramPopupMenu, "清除新手tips的计数", new kfh(this, localVideoAppInterface));
      AVRedBagMgr.a(localVideoAppInterface, paramPopupMenu, "清除游戏指引的计数", new kfi(this, localVideoAppInterface));
      AVRedBagMgr.a(localVideoAppInterface, paramPopupMenu, "立即显示新手tips（正式）", new kfj(this, paramAVRedBagMgr));
      if (i != 0)
      {
        AVRedBagMgr.a(localVideoAppInterface, paramPopupMenu, "立即显示新手tips（全红）", new kfk(this, paramAVRedBagMgr));
        AVRedBagMgr.a(localVideoAppInterface, localMenu, "结果页", new kfl(this, paramAVRedBagMgr));
        AVRedBagMgr.a(localVideoAppInterface, localMenu, "发红包", new keu(this, paramAVRedBagMgr));
        AVRedBagMgr.a(localVideoAppInterface, localMenu, "测试小灰条消息", new kev(this, paramAVRedBagMgr));
        AVRedBagMgr.a(localVideoAppInterface, localMenu, "TYPE_Request_Refresh_RecordBtn", new kew(this, localVideoAppInterface, paramAVRedBagMgr));
        if (!this.jdField_b_of_type_Boolean) {
          break label388;
        }
        paramPopupMenu = "恢复正常发红包逻辑(当前已经忽略发红包错误)";
        label241:
        AVRedBagMgr.a(localVideoAppInterface, localMenu, paramPopupMenu, new key(this));
        AVRedBagMgr.a(localVideoAppInterface, localMenu, "让入口可用", new kez(this, paramAVRedBagMgr));
        AVRedBagMgr.a(localVideoAppInterface, localMenu, "reOpenCamera", new kfa(this, localVideoAppInterface));
        if (!this.jdField_a_of_type_Boolean) {
          break label394;
        }
      }
    }
    label388:
    label394:
    for (paramAVRedBagMgr = "表情掉落减速：开";; paramAVRedBagMgr = "表情掉落减速：关")
    {
      AVRedBagMgr.a(localVideoAppInterface, localMenu, paramAVRedBagMgr, new kfb(this));
      AVRedBagMgr.a(localVideoAppInterface, localMenu, "禁用C2C发包索引:" + this.jdField_a_of_type_Int, new kfc(this));
      AVRedBagMgr.a(localVideoAppInterface, localMenu, "显示debuginfo", new kfd(this, localVideoAppInterface));
      return;
      i = 0;
      break;
      paramPopupMenu = "忽略发红包错误(当前是发红包的正常逻辑)";
      break label241;
    }
  }
  
  public void b(AVRedBagMgr paramAVRedBagMgr)
  {
    RedBagUtil.a(paramAVRedBagMgr.a(), paramAVRedBagMgr.a().getCurrentAccountUin(), 0, "测试代码\n游戏结束通知, mStarter");
  }
  
  public void c(AVRedBagMgr paramAVRedBagMgr)
  {
    paramAVRedBagMgr.a().finish();
    paramAVRedBagMgr.a().a().postDelayed(new ket(this, paramAVRedBagMgr), 3000L);
  }
  
  public void d(AVRedBagMgr paramAVRedBagMgr)
  {
    paramAVRedBagMgr.a().finish();
    paramAVRedBagMgr.a().a().postDelayed(new kfe(this, paramAVRedBagMgr), 5000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.ui.redbag.AVRedBagMgr.TestFlag
 * JD-Core Version:    0.7.0.1
 */