package com.tencent.gdtad.jsbridge;

import com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin;
import qja;
import qjb;
import qjc;
import qje;
import qjf;
import qjg;
import qjh;

public class GdtAdPluginFactory
  extends VasWebviewJsPlugin
{
  private static GdtAdPluginFactory jdField_a_of_type_ComTencentGdtadJsbridgeGdtAdPluginFactory;
  GdtAdReportJsCallHandler jdField_a_of_type_ComTencentGdtadJsbridgeGdtAdReportJsCallHandler;
  GdtAppJumpJsCallHandler jdField_a_of_type_ComTencentGdtadJsbridgeGdtAppJumpJsCallHandler;
  GdtLoadAdJsCallHandler jdField_a_of_type_ComTencentGdtadJsbridgeGdtLoadAdJsCallHandler;
  GdtLocationJsCallHandler jdField_a_of_type_ComTencentGdtadJsbridgeGdtLocationJsCallHandler;
  qja jdField_a_of_type_Qja;
  qjb jdField_a_of_type_Qjb;
  qjc jdField_a_of_type_Qjc;
  qje jdField_a_of_type_Qje;
  qjf jdField_a_of_type_Qjf;
  qjg jdField_a_of_type_Qjg;
  qjh jdField_a_of_type_Qjh;
  
  public static GdtAdPluginFactory a()
  {
    if (jdField_a_of_type_ComTencentGdtadJsbridgeGdtAdPluginFactory == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentGdtadJsbridgeGdtAdPluginFactory == null) {
        jdField_a_of_type_ComTencentGdtadJsbridgeGdtAdPluginFactory = new GdtAdPluginFactory();
      }
      return jdField_a_of_type_ComTencentGdtadJsbridgeGdtAdPluginFactory;
    }
    finally {}
  }
  
  public GdtJsCallHandler a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      if (this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtAppJumpJsCallHandler == null) {
        this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtAppJumpJsCallHandler = new GdtAppJumpJsCallHandler();
      }
      return this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtAppJumpJsCallHandler;
    case 2: 
      if (this.jdField_a_of_type_Qjh == null) {
        this.jdField_a_of_type_Qjh = new qjh();
      }
      return this.jdField_a_of_type_Qjh;
    case 3: 
      if (this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtAdReportJsCallHandler == null) {
        this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtAdReportJsCallHandler = new GdtAdReportJsCallHandler();
      }
      return this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtAdReportJsCallHandler;
    case 4: 
      if (this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtLocationJsCallHandler == null) {
        this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtLocationJsCallHandler = new GdtLocationJsCallHandler();
      }
      return this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtLocationJsCallHandler;
    case 5: 
      if (this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtLoadAdJsCallHandler == null) {
        this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtLoadAdJsCallHandler = new GdtLoadAdJsCallHandler();
      }
      return this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtLoadAdJsCallHandler;
    case 6: 
      if (this.jdField_a_of_type_Qja == null) {
        this.jdField_a_of_type_Qja = new qja();
      }
      return this.jdField_a_of_type_Qja;
    case 7: 
      if (this.jdField_a_of_type_Qjc == null) {
        this.jdField_a_of_type_Qjc = new qjc();
      }
      return this.jdField_a_of_type_Qjc;
    case 8: 
      if (this.jdField_a_of_type_Qje == null) {
        this.jdField_a_of_type_Qje = new qje();
      }
      return this.jdField_a_of_type_Qje;
    case 9: 
      if (this.jdField_a_of_type_Qjb == null) {
        this.jdField_a_of_type_Qjb = new qjb();
      }
      return this.jdField_a_of_type_Qjb;
    case 10: 
      if (this.jdField_a_of_type_Qjf == null) {
        this.jdField_a_of_type_Qjf = new qjf();
      }
      return this.jdField_a_of_type_Qjf;
    }
    if (this.jdField_a_of_type_Qjg == null) {
      this.jdField_a_of_type_Qjg = new qjg();
    }
    return this.jdField_a_of_type_Qjg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\c222.jar
 * Qualified Name:     com.tencent.gdtad.jsbridge.GdtAdPluginFactory
 * JD-Core Version:    0.7.0.1
 */