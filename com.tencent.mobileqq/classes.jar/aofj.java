import android.util.SparseArray;
import com.tencent.biz.qqstory.takevideo.artfilter.ArtFilterManager;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.AudioDeviceManager;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.stickerrecommended.scenesrecommend.ScenesRecommendManager;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.app.DeviceProfileManager.AccountDpcManager;
import com.tencent.mobileqq.app.NearbyGrayTipsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory.2;
import com.tencent.mobileqq.app.QQManagerFactory.3;
import com.tencent.mobileqq.app.QQManagerFactory.4;
import com.tencent.mobileqq.app.SignatureManager;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.business.sougou.WordMatchManager;
import com.tencent.mobileqq.data.MsgBoxInterFollowManager;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.database.corrupt.DBFixManager;
import com.tencent.mobileqq.jsp.FaceDetectForThirdPartyManager;
import com.tencent.mobileqq.medalwall.MedalWallMng;
import com.tencent.mobileqq.microapp.apkg.UsedAppListManager;
import com.tencent.mobileqq.mini.apkgEntity.MiniAppEntityManager;
import com.tencent.mobileqq.mini.entry.MiniAppLocalSearchManager;
import com.tencent.mobileqq.mini.entry.MiniAppUserAppInfoListManager;
import com.tencent.mobileqq.mini.entry.search.data.MiniAppSearchDataManager;
import com.tencent.mobileqq.olympic.OlympicManager;
import com.tencent.mobileqq.portal.PortalManager;
import com.tencent.mobileqq.profile.like.PraiseManager;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.troop.widget.UsingTimeReportManager;
import com.tencent.mobileqq.upgrade.UpgradeTIMManager;
import com.tencent.mobileqq.utils.BusinessCommonConfig;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.photoplus.PhotoPlusManager;
import cooperation.troop.TroopPluginManager;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AccountManagerImpl;
import mqq.app.AppRuntime;
import mqq.app.ProxyIpManagerImpl;
import mqq.manager.Manager;

public final class aofj
{
  private static SparseArray<Class<? extends Manager>> jdField_a_of_type_AndroidUtilSparseArray = new aofk(512);
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private static ArrayList<Integer> jdField_a_of_type_JavaUtilArrayList = new QQManagerFactory.2();
  private static AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private static ArrayList<Integer> b = new QQManagerFactory.3();
  private static ArrayList<Integer> c = new QQManagerFactory.4();
  
  public static Manager a(int paramInt, QQAppInterface paramQQAppInterface)
  {
    Manager localManager = b(paramInt, paramQQAppInterface);
    if (localManager != null) {
      return localManager;
    }
    for (;;)
    {
      Class localClass;
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        if ((jdField_a_of_type_AndroidUtilSparseArray.indexOfKey(paramInt) < 0) && (!jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()))
        {
          QLog.e("QQManagerFactory", 1, "First trigger lazyLoad, name=" + paramInt);
          if (QLog.isColorLevel()) {
            QLog.d("QQManagerFactory", 2, "First trigger stack=", new RuntimeException("First trigger manager lazyLoad"));
          }
          a();
          jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
        }
        localClass = (Class)jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
        if (localClass == null)
        {
          QLog.e("QQManagerFactory", 1, "Not Found Manager, name=" + paramInt);
          paramQQAppInterface = localManager;
          return paramQQAppInterface;
        }
      }
      try
      {
        if (jdField_a_of_type_JavaUtilArrayList.contains(Integer.valueOf(paramInt)))
        {
          paramQQAppInterface = (Manager)localClass.newInstance();
        }
        else if (b.contains(Integer.valueOf(paramInt)))
        {
          ??? = localClass.getDeclaredConstructor(new Class[] { AppRuntime.class });
          ((Constructor)???).setAccessible(true);
          paramQQAppInterface = (Manager)((Constructor)???).newInstance(new Object[] { paramQQAppInterface });
        }
        else if (c.contains(Integer.valueOf(paramInt)))
        {
          ??? = localClass.getDeclaredConstructor(new Class[] { AppInterface.class });
          ((Constructor)???).setAccessible(true);
          paramQQAppInterface = (Manager)((Constructor)???).newInstance(new Object[] { paramQQAppInterface });
        }
        else
        {
          ??? = localClass.getDeclaredConstructor(new Class[] { QQAppInterface.class });
          ((Constructor)???).setAccessible(true);
          paramQQAppInterface = (Manager)((Constructor)???).newInstance(new Object[] { paramQQAppInterface });
        }
      }
      catch (Exception paramQQAppInterface)
      {
        QLog.e("QQManagerFactory", 1, paramQQAppInterface, new Object[0]);
        bdkh.a(paramQQAppInterface);
        paramQQAppInterface = localManager;
      }
    }
  }
  
  private static void a()
  {
    jdField_a_of_type_AndroidUtilSparseArray.put(0, AccountManagerImpl.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(3, ProxyIpManagerImpl.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(13, WebProcessManager.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(14, axfj.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(16, axad.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(17, bdug.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(22, aoga.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(23, agid.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(24, MediaPlayerManager.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(32, bfqm.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(33, aofz.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(35, aazu.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(37, axfw.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(42, gc.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(43, askd.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(45, bhxi.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(46, AvatarPendantManager.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(54, anvo.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(55, aoha.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(173, nso.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(58, SignatureManager.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(59, anve.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(65, bbaq.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(67, aohl.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(68, DeviceProfileManager.AccountDpcManager.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(69, anxb.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(71, asak.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(72, axac.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(74, arsi.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(79, PortalManager.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(167, OlympicManager.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(168, apjt.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(80, nlh.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(82, WordMatchManager.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(83, awxo.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(84, biki.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(89, balw.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(90, babs.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(91, bayl.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(92, aocm.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(93, NearbyGrayTipsManager.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(94, bcpr.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(101, txs.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(102, ajng.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(103, ashd.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(105, aopq.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(104, bapy.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(109, bgqm.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(133, bgqk.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(172, asmn.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(106, axup.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(108, awdu.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(113, bgsu.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(114, amll.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(116, axwf.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(120, acyy.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(119, TroopPluginManager.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(128, bamr.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(127, bamk.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(121, ArkAppCenter.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(125, akwu.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(123, aoah.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(112, aqmx.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(130, apau.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(129, bmor.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(124, aocz.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(131, aoan.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(138, ajan.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(134, bdkj.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(135, akxl.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(126, apcg.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(154, anpp.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(155, annx.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(140, baok.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(141, asig.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(142, bmbb.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(152, bgtu.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(149, ashc.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(333, asgf.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(259, asgq.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(143, awuo.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(145, awzz.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(161, axuk.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(147, bmby.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(150, bhzh.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(151, PreloadManager.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(156, avoj.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(157, aqqv.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(158, pcn.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(163, pfg.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(164, bgut.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(262, bgqd.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(166, axoz.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(169, PhotoPlusManager.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(170, aope.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(349, axdx.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(174, axey.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(340, bbdj.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(348, awdv.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(370, azih.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(175, bnez.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(176, bile.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(177, bhyg.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(222, bbyb.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(179, azut.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(184, VasQuickUpdateManager.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(185, beiq.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(186, aobc.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(194, blee.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(188, ArtFilterManager.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(189, bhea.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(195, amtp.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(196, bflw.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(191, aqgr.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(192, bhzg.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(202, MsgBoxInterFollowManager.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(220, aper.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(200, axfi.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(199, apdc.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(201, azor.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(204, axuv.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(205, DBFixManager.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(206, avtm.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(367, asgg.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(207, axvr.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(209, PraiseManager.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(208, zmu.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(211, amst.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(213, bmdb.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(214, ascj.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(215, aien.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(224, bgpt.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(219, avrl.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(221, awzq.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(223, bgot.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(225, bfpr.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(226, rxd.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(227, amts.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(228, ayxt.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(229, ShortVideoResourceManager.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(230, azvx.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(231, bfui.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(235, bhzq.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(232, amum.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(234, bhbe.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(237, ogo.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(238, nws.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(268, avya.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(246, bbzz.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(240, aqqq.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(241, UsingTimeReportManager.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(242, axai.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(249, angf.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(243, zyh.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(247, axzv.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(254, lun.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(278, BusinessCommonConfig.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(245, alao.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(248, nzi.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(250, MedalWallMng.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(251, wwg.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(253, wiz.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(260, bige.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(256, UpgradeTIMManager.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(258, aiyz.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(261, qtw.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(263, ayrf.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(266, ayvj.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(267, awbv.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(270, qtq.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(271, qtp.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(272, bedb.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(305, bedn.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(273, alex.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(286, auvv.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(283, bebp.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(289, bfyj.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(290, bimo.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(291, bmet.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(287, com.tencent.mobileqq.microapp.apkg.ApkgConfigManager.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(302, com.tencent.mobileqq.mini.apkg.ApkgConfigManager.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(288, UsedAppListManager.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(285, bbcd.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(293, bmyi.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(294, bboe.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(299, aohb.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(301, FaceDetectForThirdPartyManager.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(303, axae.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(279, apgc.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(304, beev.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(306, awcc.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(308, axab.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(307, tnt.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(309, MiniAppUserAppInfoListManager.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(310, MiniAppLocalSearchManager.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(311, avqm.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(312, bayq.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(314, aiti.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(318, bchi.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(316, avyp.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(317, atsh.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(319, azhg.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(324, axqb.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(326, bbnr.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(320, artf.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(323, avgx.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(327, aiay.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(325, axlc.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(328, aqjs.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(329, axnl.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(334, asfy.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(337, tny.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(352, bann.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(338, awfa.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(351, bmqf.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(345, axsq.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(347, axor.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(350, avcd.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(353, avik.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(355, bgks.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(362, bdvj.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(354, AudioDeviceManager.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(356, rgo.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(371, anxm.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(374, bidq.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(360, MiniAppSearchDataManager.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(357, bgor.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(358, avld.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(341, akxs.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(361, bdup.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(364, ScenesRecommendManager.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(365, aixd.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(366, alqe.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(368, bejo.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(372, axox.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(375, bglf.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(377, bemr.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(378, agdj.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(379, avot.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(380, aqpc.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(381, bfuo.class);
  }
  
  private static Manager b(int paramInt, QQAppInterface paramQQAppInterface)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 27: 
      return bmgk.a(paramQQAppInterface);
    case 15: 
      return bbvd.a(paramQQAppInterface);
    case 51: 
      return new anyw(paramQQAppInterface, paramQQAppInterface.a().createEntityManager());
    }
    return new MiniAppEntityManager(paramQQAppInterface.c());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aofj
 * JD-Core Version:    0.7.0.1
 */