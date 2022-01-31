package com.tencent.filter.ttpic;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;

public class TTPicFilterFactory
{
  public static BaseFilter creatFilterById(int paramInt)
  {
    switch (paramInt)
    {
    case 202: 
    case 203: 
    case 214: 
    case 218: 
    case 221: 
    case 231: 
    default: 
      return new BaseFilter(GLSLRender.FILTER_SHADER_NONE);
    case 200: 
      return new ShiShangSHFilter();
    case 201: 
      return new ShiShangSHFilter(1);
    case 230: 
      return new FaceBeautyAutoFilter();
    case 204: 
      return new FenFilter();
    case 205: 
      return new FuGuHuangFilter();
    case 206: 
      return new GaoGuangLanZiFilter();
    case 207: 
      return new BlackWhiteFilter();
    case 208: 
      return new HuaiJiuFilter();
    case 209: 
      return new JiaoPianFilter();
    case 210: 
      return new LanFilter();
    case 211: 
      return new LanTuiSeFilter();
    case 212: 
      return new MoLvFilter();
    case 213: 
      return new NuanHuangFilter();
    case 215: 
      return new Fen2Filter();
    case 216: 
      return new BlackWhite2Filter();
    case 217: 
      return new Drama2Filter();
    case 219: 
      return new FuGuFilter();
    case 220: 
      return new BlackWhite3Filter();
    case 223: 
      return new GaoLengFilter();
    case 222: 
      return new SnowFilter();
    case 224: 
      return new BeautysRealAutoFilter();
    case 225: 
      return new BlurHighRealFilter();
    case 226: 
      return new BlackWhite4Filter();
    case 227: 
      return new MenghuanFilter();
    case 228: 
      return new NaichaFilter();
    case 229: 
      return new SenlinFilter();
    case 232: 
      return new JingWuFilter();
    case 233: 
      return new MeishiFilter();
    case 234: 
      return new FengJngFilter();
    case 235: 
      return new AutoLevelFilter();
    case 236: 
      return new PtuLinjiaFilter();
    case 241: 
      return new PtuQingCongFilter();
    case 237: 
      return new PtuLengMeiRenFilter();
    case 238: 
      return new PtuShiGuangRenFilter();
    case 239: 
      return new PtuShiShang2RenFilter();
    case 240: 
      return new PtuWenYiFanFilter();
    case 242: 
      return new QuanMinYIngDiFilter();
    case 243: 
      return new ThreeDFilter();
    case 244: 
      return new RichRedFilter();
    case 245: 
      return new LightWhiteFilter();
    case 246: 
      return new MeiGuiChuXueFilter();
    case 247: 
      return new NextDoorFilter();
    case 248: 
      return new ThursdayFilter();
    case 249: 
      return new RichBlueFilter();
    case 250: 
      return new RichYellowFilter();
    case 251: 
      return new MilkGreenFilter();
    case 252: 
      return new LightGreenFilter();
    case 253: 
      return new OkinawaFilter();
    case 254: 
      return new LightRedFilter();
    case 255: 
      return new ChongShengFilter();
    case 256: 
      return new YoungFilter();
    case 257: 
      return new DongJingFilter();
    case 258: 
      return new SapporoFilter();
    case 259: 
      return new MedSeaFilter();
    case 260: 
      return new GradientPurpleYellowFilter();
    case 261: 
      return new GradientAndyWarholCowFilter();
    case 262: 
      return new GradientGlareFondDreamFilter();
    case 263: 
      return new GradientGlareFashionFilter();
    case 264: 
      return new MilkCoffeeFilter();
    case 265: 
      return new MilkBlueFilter();
    case 266: 
      return new LollyFilter();
    case 267: 
      return new YingTaoBuDingFilter();
    case 268: 
      return new BlackWhiteZIPAIFilter();
    case 269: 
      return new CoffeeFilter();
    case 270: 
      return new TeaMilkFilter();
    case 271: 
      return new BaiChaFilter();
    case 272: 
      return new TianMeiZiPaiFilter();
    case 273: 
      return new MapleRedFilter();
    case 274: 
      return new DarkCornerPtuFilter();
    case 275: 
      return new ImageAutoLevelGPUFilter();
    case 276: 
      return new GPUImageLookupFilter();
    case 277: 
      return new TransMeiWeiFilter();
    case 278: 
      return new TransXingYeFilter();
    case 279: 
      return new TransRouHeFilter();
    case 280: 
      return new TransXinXianFilter();
    case 281: 
      return new TransKongChengFilter();
    case 282: 
      return new BaiXiFilter();
    case 283: 
      return new QiangWeiFilter();
    case 284: 
      return new QingLiangFilter();
    case 285: 
      return new XinYeFilter();
    case 286: 
      return new TangGuoMeiGuiFilter();
    case 287: 
      return new ShuiLianFilter();
    case 288: 
      return new YouJiaLiFilter();
    case 289: 
      return new ZiranFilter();
    case 290: 
      return new Fen2Filter();
    case 291: 
      return new TianMeiZiPaiFilter();
    case 292: 
      return new NuanYangFilter();
    case 293: 
      FaceBeautyAutoFilter localFaceBeautyAutoFilter = new FaceBeautyAutoFilter();
      localFaceBeautyAutoFilter.setEffectIndex(4);
      return localFaceBeautyAutoFilter;
    case 294: 
      return new WuFilter();
    case 295: 
      return new FenHongBaoFilter();
    case 296: 
      return new YingTaoBuDingFilter();
    case 297: 
      return new WuXiaFilter();
    case 298: 
      return new QingXiFilter();
    case 299: 
      return new WeiZhiDaoFilters.MeiWeiFilter();
    case 300: 
      return new WeiZhiDaoFilters.XiCanFilter();
    case 301: 
      return new WeiZhiDaoFilters.XinXianFilter();
    case 302: 
      return new WeiZhiDaoFilters.TianPinFilter();
    }
    return new WeiZhiDaoFilters.KaFeiFilter();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.filter.ttpic.TTPicFilterFactory
 * JD-Core Version:    0.7.0.1
 */